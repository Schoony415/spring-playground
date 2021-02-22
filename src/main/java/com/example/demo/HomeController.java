package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//trying to make a 404 page
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        String mystring = "Default: Hello World!";
        //path to file on my computer without the file name
        String path = "/Users/j2153034/Documents/GitHub/Spring-playground/src/main/java/com/example/demo";
        //just my file name with the leading slash
        String filename = "/TestText.txt";
        mystring = FileManager.readFileAsString(path+filename);

        return mystring;
        //return "Hello Baby";
    }
    @GetMapping("/about")
    public String about(){
        return "About page";
    }
    @GetMapping("/a")//trying to make two things goto 1 page
    public String about2(){return about();}

    //@GetMapping("/error")
    //@ExceptionHandler
    public String error(){
        return "THIS IS MY 404 PAGE, GET WRECKED NOOB!";
    }
}
