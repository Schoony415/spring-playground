package com.example.jsonpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ThemeParkController.class)
public class ThemeParkTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void testRide() throws Exception {
        // 1. Check for a 200 response, that the content type is JSON and that the name is "Splash Mountain"
    }

    @Test
    public void testRides() throws Exception {
        // 2. Check for a 200 response and that the content type is JSON
    }
}
