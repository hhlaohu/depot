package com.yiya.bean;

import java.util.Date;

public class TabFreeInOutList {
    private Integer free_in_out_id;

    private Integer pre_license_plate_id;

    private String license_plate;

    private String license_plate_all;

    private Date begin_time;

    private Date end_time;

    private Short free_type;

    public Integer getFree_in_out_id() {
        return free_in_out_id;
    }

    public void setFree_in_out_id(Integer free_in_out_id) {
        this.free_in_out_id = free_in_out_id;
    }

    public Integer getPre_license_plate_id() {
        return pre_license_plate_id;
    }

    public void setPre_license_plate_id(Integer pre_license_plate_id) {
        this.pre_license_plate_id = pre_license_plate_id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate == null ? null : license_plate.trim();
    }

    public String getLicense_plate_all() {
        return license_plate_all;
    }

    public void setLicense_plate_all(String license_plate_all) {
        this.license_plate_all = license_plate_all == null ? null : license_plate_all.trim();
    }

    public Date getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Date begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Short getFree_type() {
        return free_type;
    }

    public void setFree_type(Short free_type) {
        this.free_type = free_type;
    }
}