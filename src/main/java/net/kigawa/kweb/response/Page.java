package net.kigawa.kweb.response;

import java.net.URI;

public record Page(
        String name,
        String pagePath,
        URI pageUrl,
        URI restUrl
)
{

}
