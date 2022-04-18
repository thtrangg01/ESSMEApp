package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class HomePage {
    @SerializedName("top_experts")
    private List<Expert> topExperts;
    private List<Fields> fields;
    // private List<News> topNews;

    public List<Expert> getTopExperts() {
        return topExperts;
    }

    public void setTopExperts(List<Expert> topExperts) {
        this.topExperts = topExperts;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}
