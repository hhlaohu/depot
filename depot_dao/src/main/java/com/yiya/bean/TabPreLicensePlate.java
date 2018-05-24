package com.yiya.bean;

public class TabPreLicensePlate {
    private Integer pre_license_plate_id;

    private String pre_name;

    private String remark;

    public Integer getPre_license_plate_id() {
        return pre_license_plate_id;
    }

    public void setPre_license_plate_id(Integer pre_license_plate_id) {
        this.pre_license_plate_id = pre_license_plate_id;
    }

    public String getPre_name() {
        return pre_name;
    }

    public void setPre_name(String pre_name) {
        this.pre_name = pre_name == null ? null : pre_name.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}