package com.jsonpractice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
class Person {
    @JsonIgnore
    private String[] name;

    public Person(String name){
        this.name = name.split(" ");
    }
    public Person(){
        this.name = new String[]{""};
    }
    public Person(String first, String last){
        this.name = new String[2];
        this.name[0] = first;
        this.name[1] = last;
    }

    public String getName() { return name.toString(); }

    public void setName(String name) { this.name = name.split(" "); }
    @JsonProperty("firstName")
    public String firstName() {
        try {return name[0].substring(0, 1).toUpperCase() + name[0].substring(1).toLowerCase(); }
        catch (Exception e) {return null;}
    }
    @JsonProperty("lastName")
    public String lastName(){
        try{return name[1].substring(0,1).toUpperCase()+name[1].substring(1).toLowerCase();}
        catch(Exception e){return null;}
    }

}
