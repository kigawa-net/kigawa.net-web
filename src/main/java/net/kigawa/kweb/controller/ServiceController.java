package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.entity.Service;
import net.kigawa.kweb.repository.ServiceRepository;
import net.kigawa.kweb.response.service.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
public class ServiceController
{
    private final ServiceRepository serviceRepository;
    private final URIUtil uriUtil;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository, URIUtil uriUtil)
    {
        this.serviceRepository = serviceRepository;
        this.uriUtil = uriUtil;
    }

    @RequestMapping(value = "/api/services", name = "serviceList")
    public ServiceList serviceList()
    {
        var map = new LinkedHashMap<String, Service>();

        for (var service : serviceRepository.findAll()) {
            map.put(service.getStrId(), service);
        }

        return new ServiceList(map);
    }

    @RequestMapping(value = "/api/service/{strId}", name = "service")
    public Service service(@PathVariable String strId)
    {
        var service = uriUtil.getServiceIfExists(strId);
        if (service != null) return service;

        for (var service1 : serviceRepository.findAll()) {
            if (service1.getStrId().equals(strId)) return service1;
        }

        return new Service();
    }
}
