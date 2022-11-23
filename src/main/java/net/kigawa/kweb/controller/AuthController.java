package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController
{
    private final URIUtil uriUtil;

    @Autowired
    public AuthController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = {
            "/test"
    })
    public String top(Model model)
    {
        model.addAttribute("baseurl",
                uriUtil.urlFromMapping("root"));
        return "index";
    }
}
