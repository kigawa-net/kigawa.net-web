package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import net.kigawa.kweb.bean.URIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController
{
    private final Pages pages;
private final URIUtil uriUtil;
    @Autowired
    public AppController(Pages pages, URIUtil uriUtil)
    {
        this.pages = pages;
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = {
            "/",
            "/app/**"
    })
    public String top(Model model)
    {
        model.addAttribute("baseurl", pages.getApiRoot().toString());
        return "index";
    }
}
