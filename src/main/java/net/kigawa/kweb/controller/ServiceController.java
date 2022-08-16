package net.kigawa.kweb.controller;

import net.kigawa.kweb.response.service.Top;
import net.kigawa.kweb.bean.URIUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController
{
private final URIUtil uriUtil;

    public ServiceController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = {"/api/service/top"})
    public Top top()
    {
        return new Top(
                uriUtil.generateUrl( "/img/home-top.png")
        );
    }
}
