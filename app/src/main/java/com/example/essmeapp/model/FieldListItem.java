package com.example.essmeapp.model;

import java.util.List;


public class FieldListItem {
    private List<Fields> fields;

    public FieldListItem() { }

    public FieldListItem(List<Fields> fields) {
        this.fields = fields;
    }

    public List<Fields> getFields() {
        return fields;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }
}
