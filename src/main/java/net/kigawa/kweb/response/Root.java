package net.kigawa.kweb.response;

import java.net.URI;

public record Root(
        URI imagesUrl,
        URI servicesUrl
)
{
}
