package net.kigawa.kweb.bean

import net.kigawa.kweb.Kweb
import net.kigawa.kweb.entity.Service
import java.util.function.Consumer

class ServiceDefine(private val uriUtil: URIUtil)
{
    private val serviceMap: MutableMap<String, Consumer<Service>> = mutableMapOf()


    init
    {
        addService("top") {
            it.topImg = uriUtil.urlFromPath("/img/home-top.png")
            it.title = Kweb.SERVICE_NAME
        }
    }

    private fun addService(strId: String, createService: Consumer<Service>)
    {
        synchronized(serviceMap) {
            serviceMap[strId] = createService
        }
    }

    fun getService(strId: String): Service?
    {
        val service = Service()
        synchronized(serviceMap) { serviceMap[strId] }?.accept(service) ?: return null
        service.strId = strId
        return service
    }

    @Synchronized
    fun getServiceList(): MutableList<Service>
    {
        return getServiceMap().values.toMutableList()
    }

    fun getServiceMap(): MutableMap<String, Service>
    {
        val result = mutableMapOf<String, Service>()
        val services = synchronized(serviceMap) { LinkedHashMap(serviceMap) }

        services.forEach {
            val service = Service()
            service.strId = it.key
            it.value.accept(service)
            result[it.key] = service
        }
        return result
    }
}