package com.example.jsonpractice;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class flightsEP {

//flights/flight
// get a specific flight

   @GetMapping("/flight")
   public Flight getflight(){
       Flight myflight = new Flight();
       myflight.setDepartsOn(new Date(2017-1900,3,21,13,34));
       myflight.addTickets(new tickets(100, new Person("John Smith")));
       myflight.addTickets(new tickets(100, new Person("Albert","Einstein")));
       return myflight;

   }



//flights/
//gets all flights

    @GetMapping("/")
    public List<Flight> getFlights() {
        Flight flight1 = new Flight();
        flight1.setId(4);
        flight1.setDestination("London");
        flight1.setDepartsOn(new Date(2014 - 1900, 5, 8));
        flight1.addTickets(new tickets(200, new Person("John")));

        Flight flight2 = new Flight();
        flight2.setId(4);
        flight2.setDestination("London");
        flight2.setDepartsOn(new Date(2014 - 1900, 5, 9));
        flight2.addTickets(new tickets(300, new Person("Albert Einstein")));
        flight2.addTickets(new tickets(150, new Person("Marlyn Monroe")));


        return Arrays.asList(flight1, flight2);
    }

    @PostMapping("/tickets/total")
    public String ticketPaid(@RequestBody Flight myFlight){
       List<tickets> these = myFlight.getTickets();
       int paid = 0;
       for(tickets stub:these){
           paid+=stub.getPrice();
       }
       return ""+paid;
    }

}//end of file

/*
Spring Flights: GET a Flight

Description
Endpoint #1: Single Flight
In your spring-playground application, create an endpoint that:
Takes a GET request to /flights/flight
Renders JSON like this:
{
  "departs": "2017-04-21 14:34",
  "tickets": [
    {
      "passenger": {
        "firstName": "Some name",
        "lastName": "Some other name"
      },
      "price": 200
    }
  ]
}
NOTE: you should use a java.util.Date object in Java to represent departs
Endpoint #2: List of Flights
In your spring-playground application, create an endpoint that:
Takes a GET request to /flights
Renders JSON like this:
[
  {
    "departs": "2017-04-21 14:34",
    "tickets": [
      {
        "passenger": {
          "firstName": "Some name",
          "lastName": "Some other name"
        },
        "price": 200
      }
    ]
  },
  {
    "departs": "2017-04-21 14:34",
    "tickets": [
      {
        "passenger": {
          "firstName": "Some other name",
          "lastName": null
        },
        "price": 400
      }
    ]
  }
]
JSON Formatting
Without changing your Java method names, alter the /flights endpoint to look like this:
[
  {
    "Departs": "2017-04-21 14:34",
    "Tickets": [
      {
        "Passenger": {
          "FirstName": "Some name"
        },
        "Price": 200
      }
    ]
  }
]
All property names should have initial capital letters
For passengers it should omit the FirstName/LastName properties if the values are null
Seeing it in Development
You should be using @WebMvcTest to write tests for this. But you may also want to see it running in your dev environment. Here are a few options:
cURL
curl -i localhost:8080/flights/flight

curl -i localhost:8080/flights

 */

/*
Endpoint #1: Ticket Total
In your spring-playground application, create an endpoint that:
Takes a POST request to /flights/tickets/total with the following JSON:
  {
    "tickets": [
      {
        "passenger": {
          "firstName": "Some name",
          "lastName": "Some other name"
        },
        "price": 200
      },
      {
        "passenger": {
          "firstName": "Name B",
          "lastName": "Name C"
        },
        "price": 150
      }
    ]
  }
And calculates the sum of the ticket prices, then renders it like so:
{
  "result": 350
}
Seeing it in Development
You should be using @WebMvcTest to write tests for this. But you may also want to see it running in your dev environment. Here are a few options:
cURL
curl -X POST -H "Content-Type: application/json" -d '{
  "tickets": [
    {
      "passenger": {
        "firstName": "Some name",
        "lastName": "Some other name"
      },
      "price": 200
    },
    {
      "passenger": {
        "firstName": "Name B",
        "lastName": "Name C"
      },
      "price": 150
    }
  ]
}
' "http://localhost:8080/flights/tickets/total"

 */