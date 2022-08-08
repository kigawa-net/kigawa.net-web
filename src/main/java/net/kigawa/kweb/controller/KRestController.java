package net.kigawa.kweb.controller;

import net.kigawa.kweb.response.RootJson;
import net.kigawa.kweb.util.URIUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class KRestController
{
    @RequestMapping(value = "/api")
    public RootJson api(HttpServletRequest request)
    {
        return new RootJson(URIUtil.generateUrl(request, "/"));
    }
}
