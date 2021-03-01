package com.example.springpractice;

//import com.galvanize.RequestObjects.Search;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//this is straigt from an example
@RestController
@RequestMapping("/rb")
public class FormDataController {

    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam String from, @RequestParam("q") String query) {
        return String.format("q:%s from:%s", query, from);
    }

    @PostMapping(value = "/map-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getMapParams(@RequestParam Map<String, String> formData) {
        return formData.toString();
    }

    //@PostMapping(value = "/object-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    //public String getObjectParams(Search search) {
    //    return search.toString();
    //}

    @PostMapping("/string-example")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

}