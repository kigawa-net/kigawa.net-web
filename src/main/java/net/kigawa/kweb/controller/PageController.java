package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController
{
    private final URIUtil uriUtil;

    public PageController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = {
            "/",
            "/app/**"
    })
    public String index(Model model)
    {
        var url = uriUtil.generateUrl(RestController.class, "api").toString();
        model.addAttribute("baseurl", url);
        return "index";
    }
}
