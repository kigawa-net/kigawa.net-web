package net.kigawa.kweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
public class StudilayWebApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StudilayWebApplication.class, args);
    }
}
