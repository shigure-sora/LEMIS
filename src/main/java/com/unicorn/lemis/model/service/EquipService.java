package com.unicorn.lemis.model.service;

import com.unicorn.lemis.entity.LEMIS_Equip;

import com.unicorn.lemis.model.dao.EquipDataAccessObject;

import java.util.List;

/**
 * @author kano_dayo
 * @date 2021/6/21 11:48
 */

public class EquipService {
    private EquipDataAccessObject equipDataAccessObject;
    public EquipService(){
        this.equipDataAccessObject = new EquipDataAccessObject();
    }

    /**
     * @description 用户操作
     * @param equip
     * @return void
     */
    public void addEquip(LEMIS_Equip equip)throws Exception{
        equipDataAccessObject.insert(equip);
    }
    public void updateEquip(LEMIS_Equip equip)throws Exception{
        equipDataAccessObject.update(equip);
    }
    public void deleteEquip(String equip_no)throws Exception{
        equipDataAccessObject.delete(equip_no);
    }
    public void radomGenerateEquipno(String equip_no)throws Exception{
        equipDataAccessObject.randomid(equip_no);
    }
    public void generateEquipno(String equip_no)throws Exception{
        equipDataAccessObject.genreateEquipno(equip_no);
    }
    public void randomGenerate(LEMIS_Equip equip)throws Exception{
        equipDataAccessObject.randomcode(equip);
    }
    public List<LEMIS_Equip> equipList(LEMIS_Equip equip)throws Exception{
        return equipDataAccessObject.queryEquip(equip);
    }
    public List<LEMIS_Equip>queryProblemEquip(String status)throws Exception{
        return equipDataAccessObject.queryStatus(status);
    }





}
