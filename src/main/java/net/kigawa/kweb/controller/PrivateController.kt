package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.Preset
import net.kigawa.kweb.bean.URIUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/api/private"])
class PrivateController @Autowired constructor(private val uriUtil: URIUtil,
                                               private val preset: Preset) {
    
}