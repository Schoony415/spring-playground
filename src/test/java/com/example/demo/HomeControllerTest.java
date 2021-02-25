package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

//@RunWith(SpringRunner.class)
//@WebMvcTest(HomeController.class)
@WebMvcTest(MathService.class)
public class HomeControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void testHomePageEndpoint() throws Exception{
        // localhost:8080/
        this.mvc.perform(get("/math/").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                //.andExpect(content().string(""))//string that should appear in page
                ;

    }

/*
Examples
POST /math/area

type=circle&radius=4
Would render Area of a circle with a radius of 4 is 50.26548
POST /math/area

type=rectangle&width=4&height=7
Would render Area of a 4x7 rectangle is 28
POST /math/area

type=rectangle&radius=5

*/
    @Test
    public void endpointArea1 () throws Exception{
        String addressin =
                "/math/area";

        //String bodytext =
        //        "type=circle&radius=4";
        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("type",Arrays.asList("circle"));
        bodymap.put("radius",Arrays.asList("4"));

        String textout =
                "Area of a circle with a radius of 4 is 50.265484";

        this.mvc.perform(post(addressin)
                    .accept(MediaType.TEXT_PLAIN)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .params(bodymap))//.param("key","value"))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                    .string(textout)) // string that should appear in page
        ;
    }
    @Test
    public void endpointArea2 () throws Exception{
        String addressin =
                "/math/area";

        //String bodytext =
        //        "type=circle&radius=4";
        MultiValueMap<String,String> bodymap = new LinkedMultiValueMap<>();
        bodymap.put("type",Arrays.asList("rectangle"));
        bodymap.put("width",Arrays.asList("4"));
        bodymap.put("height",Arrays.asList("7"));

        String textout =
                "Area of a 4x7 rectangle is 28.0";

        this.mvc.perform(post(addressin)
                    .accept(MediaType.TEXT_PLAIN)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .params(bodymap))//.param("key","value"))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                    .string(textout)) // string that should appear in page
        ;
    }



}
