package com.example.jsonpractice;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
class Flight {
    private int id;
    private String destination;
    private Date departsOn;
    //@JsonIgnore
    //private List<Person> passengers;
    @JsonAlias("tickets")
    private List<tickets> ticks;
    private Person pilot;

    public Flight(List<tickets> InitialBoarding){
        //passengers = new ArrayList<>();
        //passengers.add(new Person("John Smith"));
        ticks = new ArrayList<>();
        ticks = InitialBoarding;
        //ticks.add(new tickets(200,new Person("Lady Debella")));
    }
    public Flight(){
        ticks = new ArrayList<>();
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getDepartsOn() { return departsOn; }

    public void setDepartsOn(Date dateTime) { this.departsOn = dateTime; }

    //public List<Person> getPassengers() { return passengers; }

    //public void setPassengers(List<Person> passengers) { this.passengers = passengers; }

    //public void addPassenger(Person passenger){
    //    this.passengers.add(passenger);
    //}

    public Person getPilot() { return pilot; }

    public void setPilot(Person pilot) { this.pilot = pilot; }

    public List<tickets> getTickets() {
        //this.ticks.setOccupents(passengers);
        return ticks;
    }

    //@JsonProperty("tickets")
    public void setTickets(List<tickets> ticks) {
        this.ticks = ticks;
    }

    public void addTickets(tickets stub){
        this.ticks.add(stub);
    }

}
