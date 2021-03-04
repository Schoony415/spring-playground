package com.JSONViews.Activities;

import com.JSONViews.example.Views;
import com.fasterxml.jackson.annotation.*;

@JsonPropertyOrder( "address")
public class Email {
    private int id;
    @JsonView(Views.Detailed.class)
    private String address;
    private boolean primary;

    public Email(){
        id=0;
        address="";
        primary=false;
    }
    public Email(@JsonProperty("id") int id,
                 @JsonProperty("address") String address,
                 @JsonProperty("primary") boolean primary)
    {
        this.id = id;
        this.address = address;
        this.primary = primary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    //public String toString(){return("{\"id\": "+id+", \"address\": \""+address+"\", \"primary\": "+primary+"}");}


}
