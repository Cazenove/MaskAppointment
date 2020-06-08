package com.mask.backend.resource;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LoginResource {

    @NotNull
    @Length(min = 1)
    String username;

    @NotNull
    @Length(min = 1)
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
