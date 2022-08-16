package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import net.kigawa.kweb.response.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
    private final Pages pages;

    @Autowired
    public ApiController(Pages pages)
    {
        this.pages = pages;
    }

    @RequestMapping(value = "/api")
    public Root root()
    {
        return new Root(
                pages.getSitemap()
        );
    }
}
