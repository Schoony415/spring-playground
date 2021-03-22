package com.sqlPG;

import com.sqlPG.Controller.LessonController;
import com.sqlPG.DAO.LessonRepository;
import com.sqlPG.Model.Lesson;
//import com.example.sqlPG.DAO.LessonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest(com.example.sqlPG.Controller.LessonController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    LessonRepository repository;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Transactional
    @Rollback
    public void testput() throws Exception{
        Random rand = new Random();
        Lesson testL = new Lesson();
        //testL.setId(0l);
        testL.setTitle("test"+rand.nextInt(100));
        //testL.setDeliveredOn(new Date());

        String addressin =
                "/lessons";

        String jsonstr = objectMapper.writeValueAsString(testL);

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
                .andExpect(jsonPath("$.title",is(testL.getTitle()))) // string that should appear in page
        ;
    }


    @Test
    @Transactional
    @Rollback
    public void testget() throws Exception{
        Random rand = new Random();
        Lesson testL = new Lesson();
        //testL.setId(0l);
        testL.setTitle("test"+rand.nextInt(100));
        //testL.setDeliveredOn(new Date());

        String addressin =
                "/lessons";

        String jsonstr = objectMapper.writeValueAsString(testL);

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
                //.andExpect(jsonPath("$.title",is(testL.getTitle()))) // string that should appear in page
        ;

        //building my packet
        MockHttpServletRequestBuilder request2 =
                //post test
                get(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        //.contentType(MediaType.APPLICATION_JSON)
                        //.content(jsonstr)
                ;
        //shooting the request to see what happens
        this.mvc.perform(request2)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(jsonPath("$[0].title",is(testL.getTitle()))) // string that should appear in page

        ;
    }

}//end of file
/*
Spring Lessons: Tests

Description
You already have the code for Lessons in your spring-playground, now it's time to write some tests!
Use @Transactional to ensure that data is cleared between each test.
Add a GET test
Write a test for either the GET /lessons or GET /lessons/<id> endpoint.
Insert data into the database using the repository, then assert that the JSON returned from the endpoint matches the data in the database.
Add a POST test
Write a test for either the POST /lessons
 */