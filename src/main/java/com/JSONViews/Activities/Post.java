package com.JSONViews.Activities;

import com.JSONViews.example.Views;
import com.fasterxml.jackson.annotation.*;
//import org.springframework.http.converter.json.MappingJacksonValue;

//import net.minidev.json.parser.JSONParser;
//import net.minidev.json.*;

@JsonPropertyOrder({ "user", "status" })
public class Post {
    @JsonView(Views.Compact.class)
    private User user;
    @JsonView(Views.Compact.class)
    private Status status;

    public Post(){
        this.user = new User();
        this.status = new Status();
    }
    public Post(@JsonProperty("user") User user,
                @JsonProperty("status") Status status)
    {
        this.user = user;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //public String toString(){return("{\n\"user\": "+user+"\n\"status\": "+status+"\n}");}

//    @JsonValue
//    public String getclass(){
//        return "--jsonvalue--"+user.getUsername()+"--"+(new JSONObject(status));
//    }

}
