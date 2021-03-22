package com.JSONViews.example;

import com.JSONViews.Activities.Activities;
import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.nashorn.internal.parser.JSONParser;
//import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.Cookie;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.JSONObject;

@WebMvcTest(EndPoints.class)
public class ConversionTest {

    @Autowired
    MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    String requestmapping = "/jsonviews";

    @Test
    public void testHomePageEndpoint() throws Exception {
        // localhost:8080/


        this.mvc.perform(get(requestmapping+"/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string("Hello World!")) // string that should appear in page
        ;
    }

    @Test
    public void testHomePageEndpoint2() throws Exception {
        /*
        JSONParser parser=new JSONParser();
        Object obj=parser.parse(new FileReader("src/test/resources/request.json"));
        JSONObject jsonObject=(JSONObject) obj;
        String jsonstr= jsonObject.toJSONString();
        //*/

        String jsonstr =
                FileManager.readFileAsString(
                        "src/test/resources/request.json"
                        //"src/test/java/com/example/request.txt"
                );

        //System.out.println(jsonstr);
        //System.out.println("0:"+jsonstr.compareTo(FileManager.readFileAsString("src/test/java/com/example/request.txt")));

        String addressin = "/";

        String textout = jsonstr;

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(requestmapping+addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr);
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
        //.andExpect(content()
        //        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCompactView() throws Exception {
/*

    User user = userService.getUsers(id);
    MappingJacksonValue value = new MappingJacksonValue(user);

    if (user.isActive()) {
        value.setSerializationView(Views.ActiveView.class);
    } else {
        value.setSerializationView(Views.InActiveView.class);
    }

    return value;
 */


        String jsonstr =
                FileManager.readFileAsString(
                        "src/test/resources/request.json"
                        //"src/test/java/com/example/request.txt"
                );

        String addressin = "/activities/simplify";

        String textout = FileManager.readFileAsString(
                "src/test/resources/compactTest.json"
        );

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(requestmapping+addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Accept",
                                "application/vnd.galvanize.compact+json")
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr);
        //shooting the request to see what happens
        System.out.println("---------------------------");
        //System.out.println(
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .json(textout))
        ;


    }


    @Test
    public void testDetailedView() throws Exception {

        String jsonstr =
                FileManager.readFileAsString(
                        "src/test/resources/request.json"
                        //"src/test/java/com/example/request.txt"
                );

        String addressin = "/activities/simplify";

        String textout =
                FileManager.readFileAsString(
                        "src/test/resources/detailedTest.json"
                );

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(requestmapping+addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Accept",
                                "application/vnd.galvanize.detailed+json")
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr);
        //shooting the request to see what happens
        //System.out.println("---------------------------");
        //System.out.println(
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .json(textout))
        ;


    }

    @Test
    public void falseTest1() throws Exception{
        this.mvc.perform(post(requestmapping+"/activities/simplify/a")
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept",
                        "application/vnd.galvanize.detailed+json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(FileManager.readFileAsString(
                        "src/test/resources/request.json"
                )))
                .andExpect(status().isOk()); // 200 class, things be good
    }
    @Test
    public void falseTest2() throws Exception{
        this.mvc.perform(post(requestmapping+"/activities/simplify/a")
                .accept(MediaType.APPLICATION_JSON)
                .header("Accept",
                        "application/vnd.galvanize.compact+json")
                .contentType(MediaType.APPLICATION_JSON)
                .content(FileManager.readFileAsString(
                        "src/test/resources/request.json"
                )))
                .andExpect(status().isOk()); // 200 class, things be good
    }
    @Test
    public void falseTest3() throws Exception{
        this.mvc.perform(post(requestmapping+"/activities/simplify/a")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(FileManager.readFileAsString(
                        "src/test/resources/request.json"
                )))
                .andExpect(status().isOk()); // 200 class, things be good
    }

}//end of file
