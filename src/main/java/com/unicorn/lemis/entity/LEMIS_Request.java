package com.unicorn.lemis.entity;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 20:43
 */

public class LEMIS_Request {
    private String req_id;
    private String equip_name;
    private String equip_no;
    private String req_repair_man;
    private String equip_series;
    private String problem;
    private String lab;
    private String status;

public LEMIS_Request(){super();}

    public LEMIS_Request(String request_id, String equip_name, String equip_no, String req_repair_man, String equip_series, String problem, String lab, String status) {
        super();
        this.req_id = request_id;
        this.equip_name = equip_name;
        this.equip_no = equip_no;
        this.req_repair_man = req_repair_man;
        this.equip_series = equip_series;
        this.problem = problem;
        this.lab = lab;
        this.status = status;
    }

    public String getRequest_id() {
        return req_id;
    }

    public void setRequest_id(String request_id) {
        this.req_id = request_id;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getEquip_no() {
        return equip_no;
    }

    public void setEquip_no(String equip_no) {
        this.equip_no = equip_no;
    }

    public String getReq_repair_man() {
        return req_repair_man;
    }

    public void setReq_repair_man(String req_repair_man) {
        this.req_repair_man = req_repair_man;
    }

    public String getEquip_series() {
        return equip_series;
    }

    public void setEquip_series(String equip_series) {
        this.equip_series = equip_series;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String setNewStatus(String status){return status;}
}
