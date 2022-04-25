package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Request {
    private ArrayList<String> topic;
    @SerializedName("Title")
    private String title;
    private String content;
    //private ArrayList<Response> response;
    @SerializedName("customer_id")
    private String customerId;
    private String uid;

    public ArrayList<String> getTopic() {
        return topic;
    }

    public Request() {
    }

    public Request(String title) {
        this.title = title;
    }

    public Request(ArrayList<String> topic, String title, String content, String customerId, String uid) {
        this.topic = topic;
        this.title = title;
        this.content = content;
        this.customerId = customerId;
        this.uid = uid;
    }

    public void setTopic(ArrayList<String> topic) {
        this.topic = topic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
