package com.example.essmeapp.model;

public class ResearchArea {
    private String _id;
    private String img;
    private String name_vn;
    private String name_en;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName_vn() {
        return name_vn;
    }

    public void setName_vn(String name_vn) {
        this.name_vn = name_vn;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    @Override
    public String toString() {
        return "ResearchArea{" +
                "_id='" + _id + '\'' +
                ", img='" + img + '\'' +
                ", name_vn='" + name_vn + '\'' +
                ", name_en='" + name_en + '\'' +
                '}';
    }
}
