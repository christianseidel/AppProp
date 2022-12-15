package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TestController {

    private final TestService testService;

    @Value("${prefix}")
    String prefix;
    @Value("${suffix}")
    String suffix;

    private final List<String> greetings = Arrays.asList("Hallo", "Moin", "Servus", "Na", "Salut", "Hi There");
    private final Random rand = new Random();
    private String last;
    private String next = greetings.get(rand.nextInt(greetings.size()));

    public TestController(TestService testService) {
        this.testService = testService;
    }


    @GetMapping(path="/api/greeting", produces="text/plain")
    public String sayHello() {
        while (next == last) {
            next = greetings.get(rand.nextInt(greetings.size()));
        }
        last = next;
        return next;
    }

    @GetMapping(path="/api/title", produces="text/plain")
    public String getTitle() {
        return prefix + " Test App v3 " + suffix;
    }


    @PostMapping("api/item/{myString}")
    public String[] createItem(@PathVariable String myString) {
        try {
            myString = testService.createItem(myString);
        } catch (Exception e) {
            myString = "this didn't work **big sigh**";
            System.out.println(e.getClass());
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        return new String[]{"Okay, Thanks. ", myString};
    }
}