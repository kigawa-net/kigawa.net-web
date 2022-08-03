package net.kigawa.kweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping(value = {"/","/app/**"})
    public String index()
    {
        return "index";
    }
}
