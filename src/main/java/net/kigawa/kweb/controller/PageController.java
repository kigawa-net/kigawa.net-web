package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
    private final Pages pages;

    @Autowired
    public PageController(Pages pages)
    {
        this.pages = pages;
    }

    @RequestMapping(value = {
            "/",
            "/app/**"
    })
    public String top(Model model)
    {
        var url = pages.getApiRoot().toString();
        model.addAttribute("baseurl", url);
        return "index";
    }
}
