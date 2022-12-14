package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TestController {

    TestService testService;

    public TestController() {
        this.testService = new TestService();
    }

    private final List<String> greetings = Arrays.asList("Hallo", "Moin", "Servus", "Na", "Salut", "Hi There");
    private final Random rand = new Random();
    private String last;
    private String next = greetings.get(rand.nextInt(greetings.size()));


    @GetMapping(path="/api/greeting", produces="text/plain")
    public String sayHello() {
        while (next == last) {
            next = greetings.get(rand.nextInt(greetings.size()));
        }
        last = next;
        return next;
    }


    @PostMapping("api/item/{item}")
    public String[] createItem(@PathVariable String item) {
        try {
            item = testService.createItem(item);
        } catch (Exception e) {
            item = "this didn't work **big sigh**";
        }
        return new String[]{"Okay, Thanks. ", item};
    }
}