package net.kigawa.kweb;

import java.net.MalformedURLException;
import java.net.URL;

public class UserConfig
{
    private static UserConfig userConfig;
    public final URL twitterURL;

    public UserConfig()
    {
        try {
            userConfig = this;
            twitterURL = new URL("");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserConfig getInstance()
    {
        return userConfig;
    }
}
