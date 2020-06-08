package com.mask.backend.resource;

import javax.validation.constraints.NotNull;

public class AppointmentGetResource {

    @NotNull
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
