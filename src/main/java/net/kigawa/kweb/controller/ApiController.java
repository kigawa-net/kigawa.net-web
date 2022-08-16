package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import net.kigawa.kweb.response.Root;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
    @RequestMapping(value = "/api")
    public Root root(Pages pages)
    {
        return new Root(
                pages.getSitemap()
        );
    }
}
