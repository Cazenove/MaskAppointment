package com.mask.backend.resource;


import io.swagger.models.auth.In;

import javax.validation.constraints.NotNull;

public class DrawListResource {

    @NotNull
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
