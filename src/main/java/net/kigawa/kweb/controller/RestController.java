package net.kigawa.kweb.controller;

import net.kigawa.kweb.response.Root;
import net.kigawa.kweb.bean.URIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    private final URIUtil uriUtil;

    public RestController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/api")
    public Root api()
    {
        return new Root(
                uriUtil.generateUrl(PageController.class, "index",
                        Model.class),
                uriUtil.generateUrl(HomeController.class, "top")
        );
    }
}
