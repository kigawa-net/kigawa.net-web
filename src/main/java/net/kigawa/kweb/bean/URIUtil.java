package net.kigawa.kweb.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

public class URIUtil
{
    private final BeanFactory beanFactory;

    private final HttpServletRequest request;

    public URIUtil(BeanFactory beanFactory, HttpServletRequest request)
    {
        this.beanFactory = beanFactory;
        this.request = request;
    }

    public URI urlFromPath(String path)
    {
        return ServletUriComponentsBuilder
                .fromRequestUri(request)
                .replacePath(path)
                .encode().build().toUri();
    }

    public String urlFromMapping(String requestMapName)
    {
        return MvcUriComponentsBuilder
                .fromMappingName(requestMapName)
                .build();
    }
    public String mappedUrlFromMapping(String requestMapName,Object... args){
        var builder=MvcUriComponentsBuilder
                .fromMappingName(requestMapName);
       return builder.buildAndExpand(args);
    }
}
