package com.example.demo;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DemoApplicationServer {

    @Value("${say.hello}")
    private String sayHello ;

    @Bean
    public String sayHello() {
        return sayHello;
    }


}
