package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.URIUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping(value = ["/auth"])
class AuthController @Autowired constructor(private val uriUtil: URIUtil) {
    @RequestMapping(value = ["/token"])
    fun token(@CookieValue("token", required = false) token: String?, response: HttpServletResponse): String {
        return "index"
    }
}