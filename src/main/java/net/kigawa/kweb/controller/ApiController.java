package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.entity.Service;
import net.kigawa.kweb.response.Root;
import net.kigawa.kweb.response.service.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController()
public class ApiController
{
    private final URIUtil uriUtil;

    @Autowired
    public ApiController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/api", name = "root")
    public Root root()
    {
        return new Root(
                uriUtil.urlFromMapping("imageList"),
                uriUtil.urlFromMapping("serviceList"),
                uriUtil.getUrlTemplate("service")
        );
    }

}
