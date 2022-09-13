package net.kigawa.kweb.response.service;

import net.kigawa.kweb.entity.Service;

import java.util.Map;

public record ServiceList(
        Map<String, Service> serviceMap
)
{
}
