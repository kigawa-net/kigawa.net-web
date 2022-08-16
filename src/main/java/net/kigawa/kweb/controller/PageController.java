package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Pages;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
    @RequestMapping(value = {
            "/",
            "/app/**"
    })
    public String top(Pages pages, Model model)
    {
        System.out.println("get api root");
        var url = pages.getApiRoot().toString();
        model.addAttribute("baseurl", url);
        return "index";
    }
}
