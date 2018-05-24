package com.yiya.bean;

import java.util.Date;

public class TabSentryUser {
    private Integer sentry_user_id;

    private String user_name;

    private String user_pwd;

    private String real_name;

    private Short state;

    private Date crete_time;

    private Date login_time;

    private Integer login_cnt;

    public Integer getSentry_user_id() {
        return sentry_user_id;
    }

    public void setSentry_user_id(Integer sentry_user_id) {
        this.sentry_user_id = sentry_user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd == null ? null : user_pwd.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Date getCrete_time() {
        return crete_time;
    }

    public void setCrete_time(Date crete_time) {
        this.crete_time = crete_time;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Integer getLogin_cnt() {
        return login_cnt;
    }

    public void setLogin_cnt(Integer login_cnt) {
        this.login_cnt = login_cnt;
    }
}