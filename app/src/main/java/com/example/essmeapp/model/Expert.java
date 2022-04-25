package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Expert implements Serializable {
    @SerializedName("_id")
    private String id;

    private String name;

    private String degree;

    private String company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
