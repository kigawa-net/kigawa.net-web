package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.response.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController
{
    private final URIUtil uriUtil;

    @Autowired
    public ApiController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/api")
    public Root root()
    {
        return new Root(
                uriUtil.generateUrl(ImgController.class,"images")
        );
    }
}
