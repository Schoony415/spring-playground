package com.JSONViews.example;

import com.fasterxml.jackson.databind.ObjectMapper;
//import jdk.nashorn.internal.parser.JSONParser;
//import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EndPoints.class)
public class ConversionTest {

    @Autowired
    MockMvc mvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testHomePageEndpoint() throws Exception{
        // localhost:8080/


        this.mvc.perform(get("/")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .string("Hello World!")) // string that should appear in page
        ;
    }

    @Test
    public void testHomePageEndpoint2() throws Exception{
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
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
        //shooting the request to see what happens
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                //.andExpect(content()
                //        .string(textout)) // string that should appear in page
        ;
    }

    @Test
    public void testCompactView() throws Exception{
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

        //String textout = jsonstr;
        MappingJacksonValue value = new MappingJacksonValue(jsonstr);
        value.setSerializationView(Views.Compact.class);
        String textout = value.toString()+"0";//forcefail

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Accept",
                                "application/vnd.galvanize.compact+json")
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
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
    public void testDetailedView() throws Exception{

        String jsonstr =
                FileManager.readFileAsString(
                        "src/test/resources/request.json"
                        //"src/test/java/com/example/request.txt"
                );

        String addressin = "/activities/simplify";

        //String textout = jsonstr;
        MappingJacksonValue value = new MappingJacksonValue(jsonstr);
        value.setSerializationView(Views.Detailed.class);
        String textout = value.toString()+"0";//forcefail

        //building my packet
        MockHttpServletRequestBuilder request1 =
                //post test
                post(addressin)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("Accept",
                                "application/vnd.galvanize.detailed+json")
                        //for adding string body
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonstr)
                ;
        //shooting the request to see what happens
        //System.out.println("---------------------------");
        //System.out.println(
        this.mvc.perform(request1)//.param("key","value")))
                .andExpect(status().isOk()) // 200 class, things be good
                .andExpect(content()
                        .json(textout))
        ;


    }


}//end of file
