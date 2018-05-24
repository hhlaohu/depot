package com.yiya.bean;

public class TabPassagewayPicture {
    private Long passageway_pic_id;

    private Short passageway_type;

    private Long passageway_record_id;

    private Double pic_score;

    private String pic_address;

    public Long getPassageway_pic_id() {
        return passageway_pic_id;
    }

    public void setPassageway_pic_id(Long passageway_pic_id) {
        this.passageway_pic_id = passageway_pic_id;
    }

    public Short getPassageway_type() {
        return passageway_type;
    }

    public void setPassageway_type(Short passageway_type) {
        this.passageway_type = passageway_type;
    }

    public Long getPassageway_record_id() {
        return passageway_record_id;
    }

    public void setPassageway_record_id(Long passageway_record_id) {
        this.passageway_record_id = passageway_record_id;
    }

    public Double getPic_score() {
        return pic_score;
    }

    public void setPic_score(Double pic_score) {
        this.pic_score = pic_score;
    }

    public String getPic_address() {
        return pic_address;
    }

    public void setPic_address(String pic_address) {
        this.pic_address = pic_address == null ? null : pic_address.trim();
    }
}