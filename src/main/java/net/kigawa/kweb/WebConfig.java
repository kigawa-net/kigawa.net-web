package net.kigawa.kweb;

import net.kigawa.kweb.bean.Pages;
import net.kigawa.kweb.bean.URIUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Bean
    @Autowired
    public URIUtil uriUtil(BeanFactory beanFactory, HttpServletRequest request)
    {
        return new URIUtil(beanFactory, request);
    }

    @Bean
    @Autowired
    public Pages pages(URIUtil uriUtil, BeanFactory beanFactory)
    {
        if (beanFactory == null) throw new NullPointerException("bean factory is null on config");
        if (uriUtil == null) throw new NullPointerException("uri util is null on config");
        return new Pages(uriUtil, beanFactory);
    }
}
