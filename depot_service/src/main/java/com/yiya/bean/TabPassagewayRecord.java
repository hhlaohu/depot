package com.yiya.bean;

import java.util.Date;

public class TabPassagewayRecord {
    private Long passageway_record_id;

    private Short passageway_type;

    private Integer access_id;

    private Short access_type;

    private Short access_property;

    private Integer pre_license_plate_id;

    private String license_plate;

    private Date create_time;

    private Short entry_type;

    private Short is_succeed;

    private String failure_reason;

    private Integer sentry_user_id;

    private Short park_type;

    public Long getPassageway_record_id() {
        return passageway_record_id;
    }

    public void setPassageway_record_id(Long passageway_record_id) {
        this.passageway_record_id = passageway_record_id;
    }

    public Short getPassageway_type() {
        return passageway_type;
    }

    public void setPassageway_type(Short passageway_type) {
        this.passageway_type = passageway_type;
    }

    public Integer getAccess_id() {
        return access_id;
    }

    public void setAccess_id(Integer access_id) {
        this.access_id = access_id;
    }

    public Short getAccess_type() {
        return access_type;
    }

    public void setAccess_type(Short access_type) {
        this.access_type = access_type;
    }

    public Short getAccess_property() {
        return access_property;
    }

    public void setAccess_property(Short access_property) {
        this.access_property = access_property;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Short getEntry_type() {
        return entry_type;
    }

    public void setEntry_type(Short entry_type) {
        this.entry_type = entry_type;
    }

    public Short getIs_succeed() {
        return is_succeed;
    }

    public void setIs_succeed(Short is_succeed) {
        this.is_succeed = is_succeed;
    }

    public String getFailure_reason() {
        return failure_reason;
    }

    public void setFailure_reason(String failure_reason) {
        this.failure_reason = failure_reason == null ? null : failure_reason.trim();
    }

    public Integer getSentry_user_id() {
        return sentry_user_id;
    }

    public void setSentry_user_id(Integer sentry_user_id) {
        this.sentry_user_id = sentry_user_id;
    }

    public Short getPark_type() {
        return park_type;
    }

    public void setPark_type(Short park_type) {
        this.park_type = park_type;
    }
}