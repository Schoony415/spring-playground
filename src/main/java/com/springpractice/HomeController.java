package com.springpractice;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    private int viewcount=0;
    @GetMapping("/")
    public String home(){
        viewcount++;
        System.out.println("Dear Diary: Look mom! Got a view!:"+viewcount);
        String mystring = "Default: Hello World!";
        //path to file on my computer without the file name
        String path = "/Users/j2153034/Documents/GitHub/spring-playground/src/main/java/com/example/springpractice";
        String relpath = "../..";
        //just my file name with the leading slash
        String filename = "/TestText.txt";
        mystring = FileManager.readFileAsString(path+filename);

        return mystring;
        //return "Hello Baby";
    }

    @GetMapping("/tasks")
    public String getTasks() {
        return "These are tasks";
    }

    //for one item query
    //lost?item=String
    @GetMapping("/lost")
    public String foundThem(@RequestParam String item){
        return "I found your "+item+".";
    }

    @GetMapping("/about")
    public String about(){
        return "About page";
    }
    @GetMapping("/a")//trying to make two things goto 1 page
    public String about2(){return about();}

    //not working yet, need more research to make an awesome 404 page
    //@GetMapping("/error")
    //@ExceptionHandler
    public String error(){
        return "THIS IS MY 404 PAGE, GET WRECKED NOOB!";
    }

}
