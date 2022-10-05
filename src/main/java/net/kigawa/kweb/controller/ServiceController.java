package net.kigawa.kweb.controller;

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

    @Autowired
    public ServiceController(ServiceRepository serviceRepository)
    {
        this.serviceRepository = serviceRepository;
    }

    @RequestMapping(value = "/api/services", name = "serviceList")
    public ServiceList serviceList()
    {
        return new ServiceList(new HashMap<>());
    }

    @RequestMapping(value = "/api/service/{id}",name = "service")
    public Service service(@PathVariable long id)
    {
        var service = serviceRepository.findById(id);
        return service.orElseGet(Service::new);
    }
}
