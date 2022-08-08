package net.kigawa.kweb.controller;

import net.kigawa.kweb.util.URIUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController
{
    @RequestMapping(value = {
            "/",
            "/app/**"
    })
    public String index(HttpServletRequest request, Model model)
    {
        var url = URIUtil.generateUrl(request, "/api").toString();
        model.addAttribute("baseurl", url);
        return "index";
    }
}
