package net.kigawa.kweb.controller;

import net.kigawa.kweb.bean.Preset;
import net.kigawa.kweb.bean.URIUtil;
import net.kigawa.kweb.entity.Service;
import net.kigawa.kweb.repository.ServiceRepository;
import net.kigawa.kweb.response.service.ServiceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class ServiceController
{
    private final ServiceRepository serviceRepository;
    private final URIUtil uriUtil;
    private final Preset preset;

    @Autowired
    public ServiceController(ServiceRepository serviceRepository, URIUtil uriUtil, Preset preset) {
        this.serviceRepository = serviceRepository;
        this.uriUtil = uriUtil;
        this.preset = preset;
    }

    @RequestMapping(value = "/api/services", name = "serviceList")
    public ServiceList serviceList() {
        var list = new LinkedList<Service>();

        for (var service : serviceRepository.findAll()) {
            list.add(service);
        }

        list.addAll(preset.getServices().getMap().values());

        return new ServiceList(list);
    }

    @RequestMapping(value = "/api/service/{strId}", name = "service")
    public Service service(@PathVariable String strId) {
        var service = preset.getServices().get(strId);
        if (service != null) return service;

        for (var service1 : serviceRepository.findAll()) {
            if (service1.getStrId().equals(strId)) return service1;
        }

        return null;
    }
}
