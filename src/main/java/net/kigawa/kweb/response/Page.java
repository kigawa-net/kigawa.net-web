package net.kigawa.kweb.response;

import java.net.URI;

public record Page(
        String name,
        URI pageUrl,
        URI restUrl
)
{
}
