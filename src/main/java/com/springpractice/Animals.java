package com.springpractice;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animal")
public class Animals {
    //for multiple item query
    //animal?a=String&i=number
    @GetMapping("/")
    public String foundThem(@RequestParam String a, String i){
        //System.out.println("a"+a+"i"+i);
        return a+" is the best when they are "+i+"!";
    }
    //having a variable in the url bit
    @GetMapping("/{dogtag}")
    public String getspecificanimal(@PathVariable String dogtag){
        return "Is this your dog #"+dogtag+"?";
    }
    //not caring what a piece of the url is
    @GetMapping("/{dogtag}/socks")
    public String getanimalsocks(@PathVariable String dogtag){
        return "Your dog's ("+dogtag+") has nice socks";
    }

}
