package net.kigawa.kweb.bean

import net.kigawa.kweb.entity.Service
import java.util.function.Supplier

class ServiceDefine(private val uriUtil: URIUtil)
{
    private val serviceMap: MutableMap<String, Supplier<Service>> = mutableMapOf()


    init
    {
        addService("top") {
            Service.create(uriUtil.urlFromPath("/img/home-top.png"), "kigawa.net", "top",
                "kigawa.net homepage")
        }
    }

    private fun addService(strId: String, createService: Supplier<Service>)
    {
        synchronized(serviceMap) {
            serviceMap[strId] = createService
        }
    }

    fun getService(strId: String): Service?
    {
        val service = synchronized(serviceMap) { serviceMap[strId] }?.get() ?: return null
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
            val service = it.value.get()
            service.strId = it.key
            result[it.key] = service
        }
        return result
    }
}