package com.JSONViews.Activities;

import com.JSONViews.example.Views;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    @JsonView(Views.Compact.class)
    private List<Post> activities;

    public Activities(){
        activities = new ArrayList<>();
    }
    public Activities(@JsonProperty("activities") List<Post> activities)
    {
        this.activities = activities;
    }

    public List<Post> getActivities() {
        return activities;
    }

    public void setActivities(List<Post> activities) {
        this.activities = activities;
    }

//    public String toString(){
//        String temp = "{\n\"activities\": [\n";
//        for(Post a: activities) {
//            temp = temp + a.toString();
//            if (activities.get(activities.size() - 1) != a)
//                temp= temp+ ",";
//            temp=temp+ "\n";
//        }
//        temp = temp+"] \n}";
//        return temp;
//    }
}
