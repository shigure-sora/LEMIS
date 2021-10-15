package com.unicorn.lemis.model.service;

import com.unicorn.lemis.entity.LEMIS_Lab;
import com.unicorn.lemis.model.dao.LabDataAccessObject;

import java.util.List;

/**
 * @author kano_dayo
 * @date 2021/10/15 14:05
 */

public class LabService {
    private LabDataAccessObject labDataAccessObject;
    public LabService(){this.labDataAccessObject = new LabDataAccessObject();}


    public void addLab(LEMIS_Lab lab)throws Exception{
        labDataAccessObject.insert(lab);
    }
    public void updateLab(LEMIS_Lab lab)throws Exception{
        labDataAccessObject.update(lab);
    }
    public void deleteLab(String lab_no)throws Exception{
        labDataAccessObject.delete(lab_no);
    }
    public List<LEMIS_Lab> labList(LEMIS_Lab lab)throws Exception{
        return labDataAccessObject.queryLab(lab);
    }
    public List<LEMIS_Lab> lemis_labList(String lab_name)throws Exception{
        return labDataAccessObject.queryLaboratory(lab_name);
    }
}
