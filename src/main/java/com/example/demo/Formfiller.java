package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class Formfiller {
    @GetMapping("/")
    public String carhome(){
        return "info page";
    }



}
