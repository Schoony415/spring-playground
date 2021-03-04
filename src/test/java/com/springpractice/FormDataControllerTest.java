package com.springpractice;

//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//----------
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//---------

import java.util.Random;


//@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateComment() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/comments")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", "Dwayne");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s!", content)));
    }

}
