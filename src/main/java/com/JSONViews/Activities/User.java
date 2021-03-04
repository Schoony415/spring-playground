package com.JSONViews.Activities;

import com.JSONViews.example.Views;
import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({ "userId", "user" , "emails" })
public class User {
    @JsonView(Views.Detailed.class)//, "Alias" = "userId")
    private int userId;
    @JsonView(Views.Compact.class)
    private String user;
    @JsonView(Views.Detailed.class)
    private List<Email> emails;

    public User(){
        userId = 0;
        user ="";
        emails = new ArrayList<>();
    }
    public User(@JsonProperty("id") int id,
                @JsonProperty("username") String username,
                @JsonProperty("emails") List<Email> emails)
    {
        this.userId = id;
        this.user = username;
        this.emails = emails;
    }

    //@JsonGetter("userId")
    public int getId() {
        return userId;
    }

    //@JsonSetter("id")
    public void setId(int id) {
        this.userId = id;
    }

    public String getUsername() {
        return user;
    }

    public void setUsername(String username) {
        this.user = username;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

//    public String toString() {
//        String temp = "{\n" +
//                "\"id\": " + userId + ",\n" +
//                "\"username\": \"" + user + "\",\n" +
//                "\"emails\": [\n";
//        for (Email e : emails){
//            temp = temp + "" + e.toString();
//            if(emails.get(emails.size()-1)!=e)
//                temp=temp+ ",";
//            temp=temp+ "\n";
//        }
//        temp=temp+ "]\n}";
//        return temp;
//    }



}
