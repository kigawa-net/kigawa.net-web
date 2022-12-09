package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.Preset
import net.kigawa.kweb.bean.URIUtil
import net.kigawa.kweb.entity.Theme
import net.kigawa.kweb.response.ImageList
import net.kigawa.kweb.response.Root
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/private-api"])
class PrivateApiController @Autowired constructor(private val uriUtil: URIUtil,
                                                  private val preset: Preset) {
    
}