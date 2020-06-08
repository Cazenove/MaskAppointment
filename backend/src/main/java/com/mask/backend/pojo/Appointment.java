package com.mask.backend.pojo;

import java.io.Serializable;

public class Appointment implements Serializable {
    private Integer id;

    private Integer maxx;

    private Integer limitt;

    private String starttime;

    private String endtime;

    private Integer statuss;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }
}