package com.unicorn.lemis.model.dao;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.entity.LEMIS_Lab;
import com.unicorn.lemis.model.feature.EquipEdit;
import com.unicorn.lemis.model.feature.LabEdit;
import com.unicorn.lemis.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.unicorn.lemis.util.DataBaseUtil.getConn;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 19:25
 */

public class LabDataAccessObject {

    private DataBaseUtil dataBaseUtil;
    public LabDataAccessObject(){dataBaseUtil = new DataBaseUtil();}

    /**
     * @description insert Laboratory data
     * @param [lab]
     * @return void
     */
    public void insert(LEMIS_Lab lab)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "insert into laboratory(lab_id,lab_name,lab_equip,lab_technician,lab_dept,lab_sit,lab_status)values('"+lab.getLab_id()+"','"+lab.getLab_name()+"','"+lab.getLab_equip()+"','"+lab.getLab_technician()+"','"+lab.getLab_dept()+"','"+lab.getLab_sit()+"','"+lab.getLab_status()+"')";
        try{
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            LOGGER.info("insert successful");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }

    /**
     * @description Edit or update Laboratory data
     * @param [lab]
     * @return void
     */

    public void update(LEMIS_Lab lab)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        String laboratory_id =  LabEdit.lid;
        //TODO sql command 2021/6/18
        String sql = "update laboratory set lab_name='"+lab.getLab_name()+ "',lab_equip='"+lab.getLab_equip()+"',lab_technician='"+lab.getLab_technician()+"',lab_dept='"+lab.getLab_dept()+"',lab_sit='"+lab.getLab_sit()+"',lab_status='"+lab.getLab_status()+"' WHERE lab_id='"+laboratory_id+"'";
        try{
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            int update = preparedStatement.executeUpdate(sql);
            LOGGER.info("update successful");
            // TODO: 2021/6/18 it seems like i have something to do?
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }

    /**
     * @description Delete Laboratory data by lab_id
     * @param [lab_id]
     * @return void
     */

    public void delete(String lab_id)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "delete from laboratory where lab_id='"+lab_id+"'";
        try {
            //TODO Not done yet
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            int update = preparedStatement.executeUpdate(sql);
            LOGGER.info("delete successful");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }
    /**
     * @description Query Laboratory data
     * @param [example]
     * @return java.util.ArrayList<com.unicorn.lemis.entity.LEMIS_Lab>
     */
// TODO: 2021/6/23 Bug fixed
    public List<LEMIS_Lab> queryLab(LEMIS_Lab example)throws SQLException{
        List<LEMIS_Lab> results = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        //声明存放占位符?
        List<Object> params=new ArrayList<Object>();
        int index = 1;
        String sql="select * from laboratory where 1=1";
        try{
            connection= getConn();
            preparedStatement=connection.prepareStatement(sql);
            //拼接SQL语句
            if(example!=null){
                if(example.getLab_id()!=null&&!"".equals(example.getLab_id().trim())) {
                    sql = sql + " and lab_id =?";
                    params.add(example.getLab_id());
                }
                if(example.getLab_name()!=null&&!"".equals(example.getLab_name().trim())){
                    sql=sql+" and lab_name = ?";
                    params.add(example.getLab_name()+"%");
                }
                if(example.getLab_equip()!=null&&!"".equals(example.getLab_equip().trim())){
                    sql=sql+" and lab_equip = ?";
                    params.add(example.getLab_equip());
                }
                if(example.getLab_technician()!=null&&!"".equals(example.getLab_technician().trim())){
                    sql=sql+" and  lab_technician = ?";
                    params.add(example.getLab_technician());
                }
                if(example.getLab_dept()!=null&&!"".equals(example.getLab_dept().trim())){
                    sql=sql+" and lab_dept = ?";
                    params.add(example.getLab_dept());
                }
                if(example.getLab_sit()!=null&&!"".equals(example.getLab_sit().trim())){
                    sql=sql+" and lab_sit = ?";
                    params.add(example.getLab_sit());
                }
                if(example.getLab_status()!=null&&!"".equals(example.getLab_status().trim())){
                    sql=sql+" and lab_status = ?";
                    params.add(example.getLab_status());
                }

            }
            //执行sql语句
            resultSet=preparedStatement.executeQuery();
            //遍历结果集results
            results=new ArrayList<LEMIS_Lab>();
            //调用next()移动游标至当前遍历的行
            while(resultSet.next()){
                //读取行记录内容
                String lab_id = resultSet.getString("lab_id");
                String lab_name1 = resultSet.getString("lab_name");
                String lab_equip = resultSet.getString("lab_equip");
                String lab_technician = resultSet.getString("lab_technician");
                String lab_dept = resultSet.getString("lab_dept");
                String lab_sit = resultSet.getString("lab_sit");
                String lab_status = resultSet.getString("lab_status");
                //转换为对象
                LEMIS_Lab lab = new LEMIS_Lab();
                lab.setLab_id(lab_id);
                lab.setLab_name(lab_name1);
                lab.setLab_equip(lab_equip);
                lab.setLab_technician(lab_technician);
                lab.setLab_dept(lab_dept);
                lab.setLab_sit(lab_sit);
                lab.setLab_status(lab_status);
                //加入集合对象results
                results.add(lab);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DataBaseUtil.close(connection,preparedStatement,null);
        }

        return results;
    }

    /**
     * @description QueryLaboratoryInfo by lab_name
     * @param []
     * @return java.util.List<com.unicorn.lemis.entity.LEMIS_Lab>
     */

    public List<LEMIS_Lab> queryLaboratory(String lab_name){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        List<LEMIS_Lab> list=new ArrayList<LEMIS_Lab>();
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from laboratory where lab_name=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, lab_name);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String lab_id = resultSet.getString("lab_id");
                String lab_name1 = resultSet.getString("lab_name");
                String lab_equip = resultSet.getString("lab_equip");
                String lab_technician = resultSet.getString("lab_technician");
                String lab_dept = resultSet.getString("lab_dept");
                String lab_sit = resultSet.getString("lab_sit");
                String lab_status = resultSet.getString("lab_status");
                LEMIS_Lab lab = new LEMIS_Lab();
                lab.setLab_id(lab_id);
                lab.setLab_name(lab_name1);
                lab.setLab_equip(lab_equip);
                lab.setLab_technician(lab_technician);
                lab.setLab_dept(lab_dept);
                lab.setLab_sit(lab_sit);
                lab.setLab_status(lab_status);
                list.add(lab);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            DataBaseUtil.close(connection,preparedStatement,resultSet);
        }

        return list;
    }

    /**
     * @description Randomly generated lab_id
     * @param [lab]
     * @param lab
     * @return java.lang.String
     */
    public String randomid(String lab)throws Exception{
        String lab_id = "0";
        Random random = new Random();
        for(int i=0;i<=1;i++){
            lab_id = String.valueOf(random.nextInt(400000000) + 316381099);
        }
        return lab_id;
    }

    /**
     * @description Randomly generated lab code
     * @param [lab]
     * @return java.lang.String
     */

    public String randomcode(LEMIS_Lab lab)throws Exception{
        String lab_id = "0";
        Random random = new Random();
        for(int i=0;i<=1;i++){
            lab_id = String.valueOf(random.nextInt(999999) + 100000);
        }
        return lab_id;
    }

    /**
     * @description Sequential generation of Lab_id
     * @param [lab]
     * @param lab
     * @return java.lang.String
     */
    public String genreateLabid(String lab)throws Exception{
        int lab_id = 316381099;
        String genreated = Integer.toString(lab_id++);
        return genreated;
    }
    public static void init(){
        LabDataAccessObject object = new LabDataAccessObject();
    }
}
