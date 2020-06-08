package com.mask.backend.resource;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AppointmentStartResource {

    @NotNull
    @Min(1)
    Integer max;

    @NotNull
    @Min(1)
    Integer limit;

    @NotNull
    @Length(min = 1, max = 255)
    String startTime;

    @NotNull
    @Length(min = 1, max = 255)
    String endTime;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
