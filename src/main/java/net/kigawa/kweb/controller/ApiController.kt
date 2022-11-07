package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.URIUtil
import net.kigawa.kweb.entity.Theme
import net.kigawa.kweb.response.ImageList
import net.kigawa.kweb.response.Root
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping(value = ["/api"])
class ApiController @Autowired constructor(private val uriUtil: URIUtil)
{
    @RequestMapping(value = [""], name = "root")
    fun root(): Root
    {
        return Root(
            uriUtil.urlFromMapping("imageList"),
            uriUtil.urlFromMapping("serviceList"),
            uriUtil.getUrlTemplate("service"),
            uriUtil.urlFromMapping("theme")
        )
    }

    @RequestMapping(value = ["/api/theme"], name = "theme")
    fun theme(): Theme
    {
        return Theme("#c7dc68", "#c3d825", "olivedrab", "#dcdcdc",
            "darkgreen", "darkgreen")
    }

    @RequestMapping(value = ["/images"], name = "imageList")
    fun imageList(): ImageList
    {
        return ImageList(
            uriUtil.urlFromPath("/img/home-top.png")
        )
    }
}