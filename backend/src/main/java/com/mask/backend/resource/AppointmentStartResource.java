package com.mask.backend.resource;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AppointmentStartResource {

    @NotNull
    @Min(1)
    Integer maxx;

    @NotNull
    @Min(1)
    Integer limitt;

    @NotNull
    @Length(min = 1, max = 255)
    String starttime;

    @NotNull
    @Length(min = 1, max = 255)
    String endtime;

    public Integer getMaxx() {
        return maxx;
    }

    public void setMaxx(Integer maxx) {
        this.maxx = maxx;
    }

    public Integer getLimitt() {
        return limitt;
    }

    public void setLimitt(Integer limitt) {
        this.limitt = limitt;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
