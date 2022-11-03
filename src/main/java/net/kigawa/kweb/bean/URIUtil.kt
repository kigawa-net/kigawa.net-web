package net.kigawa.kweb.bean;

import net.kigawa.kweb.Kweb;
import net.kigawa.kweb.entity.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

public class URIUtil
{
    private final HttpServletRequest request;
    private final RequestMappingHandlerMapping handlerMapping;

    public URIUtil(HttpServletRequest request, RequestMappingHandlerMapping handlerMapping) {
        this.request = request;
        this.handlerMapping = handlerMapping;
    }

    public String urlFromPath(String path) {
        return ServletUriComponentsBuilder
                .fromRequestUri(request)
                .replacePath(path)
                .encode().build().toUriString();
    }

    public String urlFromMapping(String requestMapName, Object... args) {
        var builder = MvcUriComponentsBuilder
                .fromMappingName(requestMapName);
        return builder.build();
    }

    public String getUrlTemplate(String requestMapName, Object... args) {
        var methods = handlerMapping.getHandlerMethodsForMappingName(requestMapName);
        if (methods == null || methods.size() == 0) throw new RuntimeException("mapping not found");
        var annotation = methods.get(0).getMethodAnnotation(RequestMapping.class);
        if (annotation == null) throw new RuntimeException("annotation not found");
        var values = annotation.value();
        if (values.length == 0) throw new RuntimeException("rout not found");
        return values[0];
    }

}
