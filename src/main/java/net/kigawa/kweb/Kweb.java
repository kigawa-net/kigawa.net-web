package net.kigawa.kweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Kweb
{
    public static final String SERVICE_NAME = "kigawa.net";

    public static void main(String[] args) {
        SpringApplication.run(Kweb.class, args);
    }
}
