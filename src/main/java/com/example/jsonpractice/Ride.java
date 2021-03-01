package com.example.jsonpractice;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ride {
    // Create properties with getter and setter methods for name (String), isOpen (boolean), and capacity (int)
    private String name;
    private boolean isOpen;
    private int capacity;

    @JsonIgnore
    private int gateCode;

    public Ride(String name){
        this.name = name;
        this.isOpen = false;
        this.capacity = 100;
    }
    public Ride(String name, boolean isOpen, int capacity) {
        this.name = name;
        this.isOpen = isOpen;
        this.capacity = capacity;
    }

    //getters setters:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean open) {
        isOpen = open;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}//end of file
