package com.yiya.bean;

import java.util.Date;

public class TabOnhandVehicle {
    private Long onhand_vehicle_id;

    private Integer access_id;

    private Integer pre_license_plate_id;

    private String license_plate;

    private Date entry_time;

    private Short park_type;

    private Integer vehicle_type_id;

    private Integer sentry_user_id;

    private Long entry_pic_id;

    private Long exit_pic_id;

    private Short is_payment;

    private Date pay_time;

    private Double real_charges;

    private Double due_charges;

    public Long getOnhand_vehicle_id() {
        return onhand_vehicle_id;
    }

    public void setOnhand_vehicle_id(Long onhand_vehicle_id) {
        this.onhand_vehicle_id = onhand_vehicle_id;
    }

    public Integer getAccess_id() {
        return access_id;
    }

    public void setAccess_id(Integer access_id) {
        this.access_id = access_id;
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

    public Date getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(Date entry_time) {
        this.entry_time = entry_time;
    }

    public Short getPark_type() {
        return park_type;
    }

    public void setPark_type(Short park_type) {
        this.park_type = park_type;
    }

    public Integer getVehicle_type_id() {
        return vehicle_type_id;
    }

    public void setVehicle_type_id(Integer vehicle_type_id) {
        this.vehicle_type_id = vehicle_type_id;
    }

    public Integer getSentry_user_id() {
        return sentry_user_id;
    }

    public void setSentry_user_id(Integer sentry_user_id) {
        this.sentry_user_id = sentry_user_id;
    }

    public Long getEntry_pic_id() {
        return entry_pic_id;
    }

    public void setEntry_pic_id(Long entry_pic_id) {
        this.entry_pic_id = entry_pic_id;
    }

    public Long getExit_pic_id() {
        return exit_pic_id;
    }

    public void setExit_pic_id(Long exit_pic_id) {
        this.exit_pic_id = exit_pic_id;
    }

    public Short getIs_payment() {
        return is_payment;
    }

    public void setIs_payment(Short is_payment) {
        this.is_payment = is_payment;
    }

    public Date getPay_time() {
        return pay_time;
    }

    public void setPay_time(Date pay_time) {
        this.pay_time = pay_time;
    }

    public Double getReal_charges() {
        return real_charges;
    }

    public void setReal_charges(Double real_charges) {
        this.real_charges = real_charges;
    }

    public Double getDue_charges() {
        return due_charges;
    }

    public void setDue_charges(Double due_charges) {
        this.due_charges = due_charges;
    }
}