package com.example.jsonpractice;

import org.springframework.web.bind.annotation.*;

@RestController
public class ThemeParkController {

    // 1. Create a GET request that takes in a String request parameter for ride name and returns a JSON Ride object

    // 2. Create a GET request that returns a list of rides as JSON Ride objects

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }
}
