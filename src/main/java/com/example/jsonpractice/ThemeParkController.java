package com.example.jsonpractice;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ThemePark")
public class ThemeParkController {
    public static List<Ride> themeParkLineUp;

    @GetMapping("/")
    public String hello() {
        return "Hello";
    }

    // 1. Create a GET request that takes in a String request parameter for ride name and returns a JSON Ride object
    @GetMapping("/ride")
    public Ride rideEP(@RequestParam String name){
        if(themeParkLineUp==null){themeParkLineUp=new ArrayList<>();}
        name = name.replaceAll("%20"," ");
        Ride myride = new Ride(name);
        themeParkLineUp.add(myride);
        return myride;
    }

    // 2. Create a GET request that returns a list of rides as JSON Ride objects
    @GetMapping("/rides")
    public List<Ride> ridesEP(){
        if(themeParkLineUp==null){themeParkLineUp=new ArrayList<>();
        themeParkLineUp.add(new Ride("Terminator"));}
        //return new Ride[]
        //        {new Ride("Splash Mountain"),
        //        new Ride("Spaceship",true,25)};
        return themeParkLineUp;
    }

}
