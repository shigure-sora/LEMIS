package com.unicorn.lemis.entity;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 19:23
 */

public class LEMIS_Lab {
    private String lab_id;
    private String lab_name;
    private String lab_equip;
    private String lab_technician;
    private String lab_dept;
    private String lab_sit;
    private String lab_status;

    public LEMIS_Lab(){super();}

    public LEMIS_Lab(String lab_id, String lab_name, String lab_equip, String lab_technician, String lab_dept, String lab_sit, String lab_status) {
        super();
        this.lab_id = lab_id;
        this.lab_name = lab_name;
        this.lab_equip = lab_equip;
        this.lab_technician = lab_technician;
        this.lab_dept = lab_dept;
        this.lab_sit = lab_sit;
        this.lab_status = lab_status;
    }

    public String getLab_id() {
        return lab_id;
    }
    public String getLab_id(String labid){return labid;}

    public void setLab_id(String lab_id) {
        this.lab_id = lab_id;
    }

    public String getLab_name() {
        return lab_name;
    }

    public void setLab_name(String lab_name) {
        this.lab_name = lab_name;
    }

    public String getLab_equip() {
        return lab_equip;
    }

    public void setLab_equip(String lab_equip) {
        this.lab_equip = lab_equip;
    }

    public String getLab_technician() {
        return lab_technician;
    }

    public void setLab_technician(String lab_technician) {
        this.lab_technician = lab_technician;
    }

    public String getLab_dept() {
        return lab_dept;
    }

    public void setLab_dept(String lab_dept) {
        this.lab_dept = lab_dept;
    }

    public String getLab_sit() {
        return lab_sit;
    }

    public void setLab_sit(String lab_sit) {
        this.lab_sit = lab_sit;
    }

    public String getLab_status() {
        return lab_status;
    }

    public void setLab_status(String lab_status) {
        this.lab_status = lab_status;
    }

}
