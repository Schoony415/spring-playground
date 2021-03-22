package com.JSONViews.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

@JsonPropertyOrder({ "userId", "user", "email", "date", "statusText" })
public class prettiefi {
    @JsonProperty("userId")@JsonView(Views.Detailed.class)
    private int id;
    @JsonProperty("user")@JsonView(Views.Compact.class)
    private String user;
    @JsonProperty("email")@JsonView(Views.Detailed.class)
    private String pemail;
    @JsonProperty("date")@JsonView(Views.Compact.class)
    private Date postDate;
    @JsonProperty("statusText")@JsonView(Views.Compact.class)
    private String postText;

    /*
        There are two possible responses, based on a header.
        When the "Accept" header is set to application/vnd.galvanize.detailed+json the response should be:
                [
        {
    detailed        "userId": 1467,
    compact            "user": "someuser",
    detailed            "email": "personal@example.com",
    compact            "date": "2017-04-02 01:32",
    compact            "statusText": "Just went snowboarding today!"
        },
    ]
    */
    public prettiefi(int id,String user,String email,Date date,String text){
        this.id = id;
        this.user = user;
        this.pemail = email;
        this.postDate = date;
        this.postText = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }



}//end of file
