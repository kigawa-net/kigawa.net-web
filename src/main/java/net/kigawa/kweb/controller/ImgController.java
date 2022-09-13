package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.response.Images;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ImgController
{
    private final URIUtil uriUtil;

    public ImgController(URIUtil uriUtil)
    {
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/images",name = "images")
    public Images images()
    {
        return new Images(
                uriUtil.urlFromPath("/img/home-top.png")
        );
    }
}
