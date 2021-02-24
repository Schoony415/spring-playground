package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/car")
public class Formfiller {
    @GetMapping("/")
    public String carhome(){
        return "car info page";
    }

    @PostMapping("/drive")
    public String formDataDriverExample(@RequestBody String car){
        return "you are driving a "+car;
    }

    @PostMapping("/walk")
    public String formDataWalkExample(@RequestParam Map<String,String> body){
        return "The person walking is "+body.get("name")+".";
    }

}
