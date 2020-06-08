package com.mask.backend.resource;

import lombok.Data;

@Data
public class QueryResult {
    private String idNum;
    private String name;
    private int appointNum;
    private String place;
    private String time;
}
