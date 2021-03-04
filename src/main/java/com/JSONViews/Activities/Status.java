package com.JSONViews.Activities;

import com.JSONViews.example.Views;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

@JsonPropertyOrder({ "date", "statusText" })
public class Status {
    @JsonView(Views.Compact.class)
    private String statusText;
    @JsonView(Views.Compact.class)
    private Date date;

    public Status(){
        statusText="";
        date = new Date();
    }
    public Status(@JsonProperty("text") String text,
                  @JsonProperty("date") Date date)
    {
        this.statusText=text;
        this.date=date;
    }

    public String getText() {
        return statusText;
    }

    public void setText(String text) {
        this.statusText = text;
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //public String toString(){return ("{\n\"text\": \""+statusText+"\",\n\"date\": \""+date+"\"\n}");}
}
