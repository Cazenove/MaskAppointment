package com.mask.backend.dto;

public class RegionalDrawDTO {

    public RegionalDrawDTO(){
        this.place = "null";
        this.count = 0;
    }

    private String place;

    private Integer count;

    public Integer getCount() { return count; }

    public void setCount(Integer count) { this.count = count; }

    public String getPlace() { return place; }

    public void setPlace(String place) { this.place = place; }
}
