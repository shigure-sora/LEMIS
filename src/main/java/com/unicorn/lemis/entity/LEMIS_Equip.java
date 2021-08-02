package com.unicorn.lemis.entity;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 19:09
 */

public class LEMIS_Equip {
    private String equip_no;
    private String equip_name;
    private String equip_lab;
    private String manufacturing_date;
    private String expiring_date;
    private String manufactory;
    private String equip_series;
    private String status;
    private String problem;
    private String req_repair_man;
    private String worker_name;

    public LEMIS_Equip(){
        super();
    }

    public LEMIS_Equip(String equip_no, String equip_name, String equip_lab, String manufacturing_date, String expiring_date, String manufactory, String equip_series, String status, String problem, String req_repair_man, String worker_name) {
        super();
        this.equip_no = equip_no;
        this.equip_name = equip_name;
        this.equip_lab = equip_lab;
        this.manufacturing_date = manufacturing_date;
        this.expiring_date = expiring_date;
        this.manufactory = manufactory;
        this.equip_series = equip_series;
        this.status = status;
        this.problem = problem;
        this.req_repair_man = req_repair_man;
        this.worker_name = worker_name;
    }

    public String getEquip_no() {
        return equip_no;
    }

    public void setEquip_no(String equip_no) {
        this.equip_no = equip_no;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public String getEquip_lab() {
        return equip_lab;
    }

    public void setEquip_lab(String equip_lab) {
        this.equip_lab = equip_lab;
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

    public String getProbelm(String status){return status;}

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getManufacturing_date() { return manufacturing_date; }

    public void setManufacturing_date(String manufacturing_date) { this.manufacturing_date = manufacturing_date; }

    public String getExpiring_date() { return expiring_date; }

    public void setExpiring_date(String expiring_date) { this.expiring_date = expiring_date; }

    public String getManufactory() { return manufactory; }

    public void setManufactory(String manufactory) { this.manufactory = manufactory; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getWorker_name() { return worker_name; }

    public void setWorker_name(String worker_name) { this.worker_name = worker_name; }
}
