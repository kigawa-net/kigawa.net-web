package net.kigawa.kweb.bean

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.MalformedURLException
import java.net.URL
import javax.servlet.http.HttpServletRequest

class URIUtil(private val request: HttpServletRequest, private val handlerMapping: RequestMappingHandlerMapping) {
    fun urlFromPath(path: String): URL {
        return try {
            URL(
                ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .replacePath(path)
                    .encode().build().toUriString()
            )
        } catch (e: MalformedURLException) {
            throw RuntimeException(e)
        }
    }

    fun urlFromMapping(requestMapName: String, vararg args: Any?): URL {
        val builder = MvcUriComponentsBuilder
            .fromMappingName(requestMapName)
        return urlFromPath(builder.buildAndExpand(args))
    }

    fun getUrlTemplate(requestMapName: String): String {
        var path = "/"
        val methods = handlerMapping.getHandlerMethodsForMappingName(requestMapName)
        if (methods == null || methods.size == 0) throw RuntimeException("mapping not found")
        val method = methods[0]
        val classAnnotation = method.beanType.getAnnotation(RequestMapping::class.java)
        if (classAnnotation != null && classAnnotation.value.isNotEmpty()) {
            var classPath = classAnnotation.value[0]
            if (classPath.startsWith("/")) classPath = classPath.substring(1, classPath.length)
            path += classPath
        }

        val annotation = method.getMethodAnnotation(RequestMapping::class.java)
            ?: throw RuntimeException("annotation not found")
        val methodValues: Array<String> = annotation.value
        if (methodValues.isEmpty()) throw RuntimeException("rout not found")
        var methodPath = methodValues[0]
        if (methodPath.startsWith("/")) methodPath = methodPath.substring(1, methodPath.length)
        if (path.endsWith("/")) path = path.substring(0, path.length - 1)
        return "$path/$methodPath"
    }
}