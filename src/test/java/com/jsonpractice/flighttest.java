package com.jsonpractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.springpractice.FileManager;

@WebMvcTest(flightsEP.class)
public class flighttest {

    @Autowired
    MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testFlight1() throws Exception {
        String addressin =
                "/flights/flight/";

        //building my packet
        MockHttpServletRequestBuilder request1 =
                get(addressin);
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()); // 200 class, things be good

    }
    @Test
    public void testHome1() throws Exception {
        String addressin =
                "/flights/";

        //building my packet
        MockHttpServletRequestBuilder request1 =
                get(addressin);
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()); // 200 class, things be good

    }

    @Test
    public void testTickets1() throws Exception{
        String jsonstr =
                "{\"id\":4,\"destination\":\"London\",\"departsOn\":\"2014-06-08 05:00\",\"tickets\":[{\"price\":200,\"passenger\":{\"firstName\":\"John\"}},{\"price\":300,\"passenger\":{\"lastName\":\"Einstein\",\"firstName\":\"Albert\"}},{\"price\":150,\"passenger\":{\"lastName\":\"Monroe\",\"firstName\":\"Marlyn\"}}]}";

        String addressin =
                "/flights/tickets/total/";

        String textout =
                "650";


        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testTickets2() throws Exception{
        Flight flight1 = new Flight();
        flight1.setId(4);
        flight1.setDestination("London");
        flight1.setDepartsOn(new Date(2014 - 1900, 5, 8));
        flight1.addTickets(new tickets(200, new Person("John")));
        flight1.addTickets(new tickets(300, new Person("Albert Einstein")));
        flight1.addTickets(new tickets(150, new Person("Marlyn Monroe")));

        String jsonstr = objectMapper.writeValueAsString(flight1);

        String addressin =
                "/flights/tickets/total/";

        String textout =
                "650";


        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }


    @Test
    public void testTickets3() throws Exception{
        String jsonstr =
                FileManager.readFileAsString(
                        "src/test/java/com/jsonpractice/myFlight.txt"
                );

        String addressin =
                "/flights/tickets/total/";

        String textout =
                "650";

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string(textout)) // string that should appear in page
        ;
    }







}//end of file
