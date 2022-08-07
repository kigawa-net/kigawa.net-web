package net.kigawa.kweb.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

public class URIUtil
{
    public static URI generateUrl(HttpServletRequest request, String path)
    {
        return ServletUriComponentsBuilder
                .fromRequestUri(request)
                .replacePath(path)
                .encode().build().toUri();
    }
}
