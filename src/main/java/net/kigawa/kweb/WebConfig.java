package net.kigawa.kweb;

import net.kigawa.kweb.bean.URIUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
    @Bean
    public URIUtil uriUtil(){
        return new URIUtil();
    }
}
