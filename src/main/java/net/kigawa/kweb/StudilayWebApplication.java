package net.kigawa.kweb;

import net.kigawa.kweb.response.HelloResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class StudilayWebApplication
{
    private final AtomicLong atomicLong = new AtomicLong();

    public static void main(String[] args)
    {
        SpringApplication.run(StudilayWebApplication.class, args);
    }

    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new HelloResponse(atomicLong.incrementAndGet(), String.format("Hello %s", name));
    }
}
