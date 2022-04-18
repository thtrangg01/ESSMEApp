package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Question {
    @SerializedName("_id")
    private String id;

    @SerializedName("Description")
    private String description;

    @SerializedName("Title")
    private String title;

    private ArrayList<Answer> answers;

    // Getter & Setter------------------------------------------------------------------------------

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
