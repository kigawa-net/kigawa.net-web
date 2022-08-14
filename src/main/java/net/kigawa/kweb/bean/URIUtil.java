package net.kigawa.kweb.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Component
public class URIUtil
{
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private HttpServletRequest request;

    public URI generateUrl(String path)
    {
        return ServletUriComponentsBuilder
                .fromRequestUri(request)
                .replacePath(path)
                .encode().build().toUri();
    }

    public URI generateUrl(Class<?> controller, String methodName, Class<?>... argClasses)
    {
        var args = new Object[argClasses.length];
        for (int i = 0; i < argClasses.length; i++) {
            if (argClasses[i].equals(Model.class)) {
                args[i] = new ModelAndView().getModel();
                continue;
            }

            args[i] = beanFactory.getBean(argClasses[i]);
        }

        return MvcUriComponentsBuilder
                .fromMethodName(controller, methodName, args)
                .buildAndExpand().toUri();
    }
}
