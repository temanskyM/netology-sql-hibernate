package ru.netology.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/api/hello")
    private String hello(){
        return "Hello!";
    }

    @GetMapping("/api/secret")
    private String helloAdmin(){
        return "Hello, Admin!!";
    }
}
