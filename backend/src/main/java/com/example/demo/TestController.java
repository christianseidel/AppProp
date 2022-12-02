package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {

    private List<String> greetings = Arrays.asList("Hallo", "Moin", "Servus");

    @Value("${say.hello}")
    private String sayHello;

    @GetMapping(path="/api/greeting", produces="text/plain")
    public String hello() {
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

    @GetMapping(path="/api/hello", produces ="text/plain")
    public String sayHello() {
        return sayHello;
    }

}