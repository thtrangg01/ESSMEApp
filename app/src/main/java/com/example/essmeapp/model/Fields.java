package com.example.essmeapp.model;

import com.google.gson.annotations.SerializedName;

public class Fields {
    @SerializedName("_id")
    private String id;
    private String name;
    @SerializedName("name_vn")
    private String nameVN;
    @SerializedName("image")
    private String imageUrl;

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

    public String getNameVN() {
        return nameVN;
    }

    public void setNameVN(String nameVN) {
        this.nameVN = nameVN;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
