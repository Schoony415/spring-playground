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
    @JsonIgnore
    private List<Person> passengers;
    private tickets ticks;
    private Person pilot;

    public Flight(){
        passengers = new ArrayList<>();
        //passengers.add(new Person("John Smith"));
        ticks = new tickets(200,passengers);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getDepartsOn() { return departsOn; }

    public void setDepartsOn(Date dateTime) { this.departsOn = dateTime; }

    public List<Person> getPassengers() { return passengers; }

    public void setPassengers(List<Person> passengers) { this.passengers = passengers; }

    public void addPassenger(Person passenger){
        this.passengers.add(passenger);
    }

    public Person getPilot() { return pilot; }

    public void setPilot(Person pilot) { this.pilot = pilot; }

    public tickets getTicks() {
        this.ticks.setOccupents(passengers);
        return ticks;
    }

    public void setTicks(tickets ticks) {
        this.ticks = ticks;
    }

    //---------------------------------------
    static class tickets{
        private List<Person> occupents;
        private int price;

        public tickets(int price, List<Person> people){
            this.price = price;
            this.occupents = people;
        }
        @JsonProperty("passenger")
        public List<Person> getOccupents() {
            return occupents;
        }

        public void setOccupents(List<Person> occupents) {
            this.occupents = occupents;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
