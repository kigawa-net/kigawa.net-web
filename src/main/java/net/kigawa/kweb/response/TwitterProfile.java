package net.kigawa.kweb.response;

import java.net.URI;

public record TwitterProfile(
        URI twitterURL,
        String userId,
        URI twitterLogoURL
)
{
}
