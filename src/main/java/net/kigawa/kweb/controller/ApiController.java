package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.response.Root;
import net.kigawa.kweb.response.service.Top;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
    private final Pages pages;
    private final URIUtil uriUtil;

    @Autowired
    public ApiController(Pages pages, URIUtil uriUtil)
    {
        this.pages = pages;
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/api")
    public Root root()
    {
        return new Root(
                pages.getRootSitemap()
        );
    }


    @RequestMapping(value = {"/api/top"})
    public Top top()
    {
        return new Top(
                uriUtil.generateUrl("/img/home-top.png")
        );
    }
}
