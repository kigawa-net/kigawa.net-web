package net.kigawa.kweb.controller;

import net.kigawa.kweb.response.Home;
import net.kigawa.kweb.response.Root;
import net.kigawa.kweb.util.URIUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@org.springframework.web.bind.annotation.RestController
public class RestController
{
    @RequestMapping(value = "/api")
    public Root api(HttpServletRequest request)
    {
        return new Root(
                URIUtil.generateUrl(request, "/"),
                URIUtil.generateUrl(request,"/api/home")
        );
    }

    @RequestMapping(value = {"/api/home"})
    public Home home(HttpServletRequest request)
    {
        return new Home(
                URIUtil.generateUrl(request, "/img/home-top.png")
        );
    }
}
