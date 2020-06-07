package com.mask.backend.pojo;

import java.io.Serializable;

public class Place implements Serializable {
    private Integer id;

    private String place;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}