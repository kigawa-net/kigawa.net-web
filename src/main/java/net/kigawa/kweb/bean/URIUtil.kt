package net.kigawa.kweb.bean

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.MalformedURLException
import java.net.URL
import javax.servlet.http.HttpServletRequest

class URIUtil(private val request: HttpServletRequest, private val handlerMapping: RequestMappingHandlerMapping)
{
    fun urlFromPath(path: String?): URL
    {
        return try
        {
            URL(ServletUriComponentsBuilder
                .fromRequestUri(request)
                .replacePath(path)
                .encode().build().toUriString())
        } catch (e: MalformedURLException)
        {
            throw RuntimeException(e)
        }
    }

    fun urlFromMapping(requestMapName: String, vararg args: Any?): String
    {
        val builder = MvcUriComponentsBuilder
            .fromMappingName(requestMapName)
        return builder.build()
    }

    fun getUrlTemplate(requestMapName: String, vararg args: Any?): String
    {
        val methods = handlerMapping.getHandlerMethodsForMappingName(requestMapName)
        if (methods == null || methods.size == 0) throw RuntimeException("mapping not found")
        val annotation = methods[0].getMethodAnnotation(RequestMapping::class.java)
            ?: throw RuntimeException("annotation not found")
        val values: Array<String> = annotation.value
        if (values.isEmpty()) throw RuntimeException("rout not found")
        return values[0]
    }
}