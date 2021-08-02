package com.unicorn.lemis.entity;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/16 0:03
 */

public class LEMIS_User {
    private String user_id;
    private String user_name;
    private String user_password;
    private String user_title;
    private String user_tele;
    private String user_dept;
    private String user_auth;
    private String user_status;
    private String user_lab;

    public LEMIS_User(){
        super();
    }

    public LEMIS_User(String user_id, String user_name,String user_password,String user_title, String user_tele, String user_dept,String user_auth,String user_status,String user_lab ) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_title = user_title;
        this.user_tele = user_tele;
        this.user_dept = user_dept;
        this.user_auth = user_auth;
        this.user_status = user_status;
        this.user_lab = user_lab;
    }

    public String getUser_id() { return user_id; }
    public String getUser_id(String user_id) { return user_id; }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }
    public String getUser_name(String user_name) {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }
    public String getUser_password(String user_password) {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_title() {
        return user_title;
    }
    public String getUser_title(String user_title) {
        return user_title;
    }

    public void setUser_title(String user_title) {
        this.user_title = user_title;
    }

    public String getUser_tele() {
        return user_tele;
    }
    public String getUser_tele(String user_tele) {
        return user_tele;
    }

    public void setUser_tele(String user_tele) {
        this.user_tele = user_tele;
    }

    public String getUser_dept() {
        return user_dept;
    }
    public String getUser_dept(String user_dept) {
        return user_dept;
    }

    public void setUser_dept(String user_dept) {
        this.user_dept = user_dept;
    }

    public String getUser_auth() {
        return user_auth;
    }
    public String getUser_auth(String user_auth) {
        return user_auth;
    }

    public void setUser_auth(String user_auth) {
        this.user_auth = user_auth;
    }

    public String getUser_lab() { return user_lab; }

    public void setUser_lab(String user_lab) { this.user_lab = user_lab; }

    public String getUser_status() { return user_status; }

    public String getUser_status(String user_status) { return user_status; }

    public void setUser_status(String user_status) { this.user_status = user_status; }
}
