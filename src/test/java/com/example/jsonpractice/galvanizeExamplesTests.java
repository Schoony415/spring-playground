package com.example.jsonpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(galvanizeExamples.class)
public class galvanizeExamplesTests {
    @Autowired
    MockMvc mvc;

    String rmapping = "/json";

    @Test
    public void testmain() throws Exception {
        // localhost:8080/
        this.mvc.perform(get(rmapping+"/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content().string("Hello"))//string that should appear in page
        ;
    }

    @Test
    public void testObject() throws Exception {
        this.mvc.perform(
                get(rmapping+"/person")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Dwayne")))
                .andExpect(jsonPath("$.lastName", is("Johnson")));
    }

    @Test
    public void testArray() throws Exception {
        this.mvc.perform(
                get(rmapping+"/people")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Dwayne")))
                .andExpect(jsonPath("$[0].lastName", is("Johnson")));
    }

}
