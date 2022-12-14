package com.example.demo;

public class TestService {

    public TestService () {

    }

    public String createItem(String item) {
        System.out.println(item);
        item = "Your last item was: " + item;
        return item;
    }
}
