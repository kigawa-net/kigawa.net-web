package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.URIUtil
import net.kigawa.kweb.response.ImageList
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class ImgController(private val uriUtil: URIUtil)
{
    @RequestMapping(value = ["/images"], name = "imageList")
    fun imageList(): ImageList
    {
        return ImageList(
            uriUtil.urlFromPath("/img/home-top.png")
        )
    }
}