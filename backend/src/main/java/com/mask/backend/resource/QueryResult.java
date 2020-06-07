package com.mask.backend.resource;

import lombok.Data;

import java.util.Date;

@Data
public class QueryResult {
    private String id;
    private String name;
    private int num;
    private String place;
    private Date time;
}
