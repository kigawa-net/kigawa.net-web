package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.entity.Service;
import net.kigawa.kweb.repository.ServiceRepository;
import net.kigawa.kweb.response.service.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
        return new ServiceList(new HashMap<>());
    }

    @RequestMapping(value = "/api/service/{strId}", name = "service")
    public Service service(@PathVariable String strId)
    {
        var service = uriUtil.getServiceIfExists(strId);
        if (service != null) return service;


        return new Service();
    }
}
