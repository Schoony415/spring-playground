package com.jsonpractice;

import com.fasterxml.jackson.annotation.JsonProperty;

class tickets{
    private Person occupent;
    private int price;

    public tickets(int price, Person people){
        this.price = price;
        this.occupent = people;
    }
    @JsonProperty("passenger")
    public Person getOccupents() {
        return occupent;
    }

    public void setOccupents(Person occupent) {
        this.occupent = occupent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}