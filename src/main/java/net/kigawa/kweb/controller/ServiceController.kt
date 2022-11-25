package net.kigawa.kweb.controller

import net.kigawa.kweb.bean.Preset
import net.kigawa.kweb.bean.URIUtil
import net.kigawa.kweb.entity.Service
import net.kigawa.kweb.repository.ServiceRepository
import net.kigawa.kweb.response.service.ServiceList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(value = ["/api/service"])
class ServiceController @Autowired constructor(
    private val serviceRepository: ServiceRepository,
    private val uriUtil: URIUtil,
    private val preset: Preset
) {
    @RequestMapping(value = ["/"], name = "serviceList")
    fun serviceList(): ServiceList {
        val list = LinkedList<Service>()
        for (service in serviceRepository.findAll()) {
            list.add(service)
        }
        list.addAll(preset.services.getMap().values)
        return ServiceList(list)
    }

    @RequestMapping(value = ["/{strId}"], name = "service")
    fun service(@PathVariable strId: String): Service? {
        val service = preset.services.get(strId)
        if (service != null) return service
        for (service1 in serviceRepository.findAll()) {
            if (service1.strId == strId) return service1
        }
        return null
    }
}