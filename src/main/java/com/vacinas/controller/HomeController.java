package com.vacinas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public Map<String, Object> helloWorld() {
        return Collections.singletonMap("greetings", "Hello World");
    }

}
