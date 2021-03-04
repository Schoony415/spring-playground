package com.JSONViews.example;

import com.JSONViews.Activities.Activities;
import com.JSONViews.Activities.Email;
import com.JSONViews.Activities.Post;
import com.example.JSONViews.Activities.*;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class EndPoints {

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @PostMapping("/")
    public String buildtest(@RequestBody Activities input){
        //Activities act = (Activities) input;
        //System.out.println(input);
        return input.toString();
    }


    @PostMapping(value = "/activities/simplify",
            produces = "application/vnd.galvanize.detailed+json")
    @JsonView(Views.Detailed.class)
    public List<Post> getUsersV1l(@RequestBody Activities input) {
        return input.getActivities();
    }

    @PostMapping(value = "/activities/simplify",
            produces = "application/vnd.galvanize.compact+json")
    @JsonView(Views.Compact.class)
    public List<Post> getUsersV2l(@RequestBody Activities input) {
        return input.getActivities();
    }

    @PostMapping(value = "/activities/simplify/a",
            produces = "application/vnd.galvanize.detailed+json")
    @JsonView(Views.Detailed.class)
    public Activities getUsersV1(@RequestBody Activities input) {
        return input;
    }

    @PostMapping(value = "/activities/simplify/a",
            produces = "application/vnd.galvanize.compact+json")
    @JsonView(Views.Compact.class)
    public Activities getUsersV2(@RequestBody Activities input) {
        return input;
    }

    @PostMapping("/activities/simplify/a")
    public List<HashMap<String,Object>> getUsersV0(@RequestBody Activities input){
        /*[
  {
    "userId": 1467,
    "user": "someuser",
    "email": "personal@example.com",
    "date": "2017-04-02 01:32",
    "statusText": "Just went snowboarding today!"
  },
  {
    "userId": 98732,
    "user": "otheruser",
    "email": "otherprimary@example.com",
    "date": "2017-04-02 01:32",
    "statusText": "Great times!"
  }
]
         */
        List<HashMap<String,Object>> output = new ArrayList<>();
        for(Post p : input.getActivities()){
            HashMap<String,Object> temp = new HashMap<>();

            temp.put("userID", p.getUser().getId());
            temp.put("user", p.getUser().getUsername());
            for(Email e : p.getUser().getEmails()){
                if(e.isPrimary()){
                    temp.put("email", e.getAddress());
                }
            }
            temp.put("date",p.getStatus().getDate());
            temp.put("statusText",p.getStatus().getText());
            output.add(temp);
        }
        return output;
    }

/*
    @PostMapping("/activities/simplify")
    public String getUsers(@RequestBody Activities input,
                                        @RequestHeader String produces){

        //User user = userService.getUsers(id);
        MappingJacksonValue value = new MappingJacksonValue(input);

        if (produces.compareTo("application/vnd.galvanize.compact+json")==0) {
            value.setSerializationView(Views.Compact.class);
        } else if(produces.compareTo("application/vnd.galvanize.detailed+json")==0){
            value.setSerializationView(Views.Detailed.class);
        }

        return value.toString();

    }
//*/


}//end of file
