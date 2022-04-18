package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;


public class Answer {
    @SerializedName("_id")
    private String id;

    private String answer;

    private int vote;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
