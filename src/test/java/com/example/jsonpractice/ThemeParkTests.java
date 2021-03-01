package com.example.jsonpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ThemeParkController.class)
public class ThemeParkTests {
    String rmapping = "/ThemePark";
    @Autowired
    MockMvc mvc;

    @Test
    public void testmain() throws Exception{
        // localhost:8080/
        this.mvc.perform(get(rmapping+"/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content().string("Hello"))//string that should appear in page
        ;
    }

    @Test
    public void testRide() throws Exception {
        String ridename = "Splash%20Mountain";
        // 1. Check for a 200 response, that the content type is JSON and that the name is "Splash Mountain"
        this.mvc.perform(get(rmapping+"/ride?name="+ridename)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())//returns 200
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            //returns the json key that is name and value that is ridename
            .andExpect(jsonPath("$.name",is(ridename)))
        ;
    }

    @Test
    public void testRides() throws Exception {
        // 2. Check for a 200 response and that the content type is JSON
        this.mvc.perform((get(rmapping+"/rides")))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        ;
    }

}
