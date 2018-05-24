package com.yiya.bean;

public class TabArea {
    private Integer area_id;

    private String area_name;

    private Integer area_parent_id;

    private Byte area_sort;

    private Boolean area_deep;

    private Boolean tesu_deleted;

    private String tesu_description;

    private Integer tesu_created;

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name == null ? null : area_name.trim();
    }

    public Integer getArea_parent_id() {
        return area_parent_id;
    }

    public void setArea_parent_id(Integer area_parent_id) {
        this.area_parent_id = area_parent_id;
    }

    public Byte getArea_sort() {
        return area_sort;
    }

    public void setArea_sort(Byte area_sort) {
        this.area_sort = area_sort;
    }

    public Boolean getArea_deep() {
        return area_deep;
    }

    public void setArea_deep(Boolean area_deep) {
        this.area_deep = area_deep;
    }

    public Boolean getTesu_deleted() {
        return tesu_deleted;
    }

    public void setTesu_deleted(Boolean tesu_deleted) {
        this.tesu_deleted = tesu_deleted;
    }

    public String getTesu_description() {
        return tesu_description;
    }

    public void setTesu_description(String tesu_description) {
        this.tesu_description = tesu_description == null ? null : tesu_description.trim();
    }

    public Integer getTesu_created() {
        return tesu_created;
    }

    public void setTesu_created(Integer tesu_created) {
        this.tesu_created = tesu_created;
    }
}