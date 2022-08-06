package net.kigawa.kweb.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{
    @RequestMapping(value = {"/", "/app/**"})
    public String index(HttpServletRequest request, Model model)
    {
        var url = ServletUriComponentsBuilder
                .fromRequestUri(request)
                .path("/api")
                .build().toUriString();
        model.addAttribute("baseurl", url);
        return "index";
    }
}
