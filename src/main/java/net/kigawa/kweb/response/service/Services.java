package net.kigawa.kweb.response.service;

import java.util.Map;

public record Services(
        Map<String,Service> serviceMap
)
{
}
