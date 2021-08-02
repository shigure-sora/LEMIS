package com.unicorn.lemis.entity;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 22:19
 */

public class LEMIS_Maintain {
    private String req_id;
    private String equip_name;
    private String equip_no;
    private String equip_series;
    private String problem;
    private String status;

    public LEMIS_Maintain(){super();}

    public LEMIS_Maintain(String req_id, String equip_name, String equip_no, String equip_series, String problem, String status) {
        super();
        this.req_id = req_id;
        this.equip_name = equip_name;
        this.equip_no = equip_no;
        this.equip_series = equip_series;
        this.problem = problem;
        this.status = status;
    }

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String setNewStatus(String status){return status;}
}
