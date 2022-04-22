package com.example.essmeapp.model;

import java.util.List;


public class FieldListItem {
    private List<ResearchArea> fields;

    public FieldListItem(List<ResearchArea> fields) {
        this.fields = fields;
    }

    public List<ResearchArea> getFields() {
        return fields;
    }

    public void setFields(List<ResearchArea> fields) {
        this.fields = fields;
    }

    public FieldListItem() {
    }
}
