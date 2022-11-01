package net.kigawa.kweb;

import net.kigawa.kweb.bean.ServiceDefine;
import net.kigawa.kweb.bean.URIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Bean
    @Autowired
    public URIUtil uriUtil(HttpServletRequest request, RequestMappingHandlerMapping handlerMapping) {
        return new URIUtil(request, handlerMapping);
    }

    @Bean
    @Autowired
    public ServiceDefine serviceDefine(URIUtil uriUtil) {
        return new ServiceDefine(uriUtil);
    }
}
