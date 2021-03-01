package com.example.springpractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//from lesson
@RestController
@RequestMapping("/app")
public class AppPages {
//public class QuerystringController {
    @GetMapping("/")
    public String appPage(){
        return "Pages: foo, bar, 123";
    }

    @GetMapping("/foo")
    public String getFoo() {
        return "<font color=#f01111>FOO!</font>";
    }

    @GetMapping("/bar")
    public String getBar() {
        return "<font color=#1111f0>BAR!!</font>";
    }

    @GetMapping("/123")
    public String get123(){
        return "Welcome to the numbers page";
    }
}

