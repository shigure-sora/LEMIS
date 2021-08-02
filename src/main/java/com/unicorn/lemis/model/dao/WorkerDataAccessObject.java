package com.unicorn.lemis.model.dao;

import com.unicorn.lemis.entity.LEMIS_Maintain;
import com.unicorn.lemis.entity.LEMIS_Request;
import com.unicorn.lemis.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.unicorn.lemis.util.DataBaseUtil.getConn;

import static com.unicorn.lemis.Launch.LOGGER;

/**
 * @author kano_dayo
 * @date 2021/6/17 22:20
 */

public class WorkerDataAccessObject {
    private DataBaseUtil dataBaseUtil;
    public WorkerDataAccessObject(){
        dataBaseUtil = new DataBaseUtil();
    }


    public List<LEMIS_Maintain> queryMaintain(LEMIS_Maintain example)throws SQLException{
        List<LEMIS_Maintain> results = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        //声明存放占位符?对应值的能动态添加元素的链表
        List<Object> params=new ArrayList<Object>();
        int index = 1;
        String sql="select * from maintain where 1=1";
        try{
            connection= getConn();
            preparedStatement=connection.prepareStatement(sql);
            //拼接SQL语句
            if(example!=null){
                if(example.getReq_id()!=null&&!"".equals(example.getReq_id().trim())) {
                    sql = sql + " and req_id =?";
                    params.add(example.getReq_id());
                }
                if(example.getEquip_name()!=null&&!"".equals(example.getEquip_name().trim())){
                    sql=sql+" and equip_name = ?";
                    params.add(example.getEquip_name()+"%");
                }
                if(example.getEquip_no()!=null&&!"".equals(example.getEquip_no().trim())){
                    sql=sql+" and equip_id = ?";
                    params.add(example.getEquip_no());
                }
                if(example.getEquip_series()!=null&&!"".equals(example.getEquip_series().trim())){
                    sql=sql+" and equip_series = ?";
                    params.add(example.getEquip_series());
                }
                if(example.getProblem()!=null&&!"".equals(example.getProblem().trim())){
                    sql=sql+" and problem = ?";
                    params.add(example.getProblem());
                }

            }
            //执行sql语句
            resultSet=preparedStatement.executeQuery();
            //遍历结果集results
            results=new ArrayList<LEMIS_Maintain>();
            //调用next()移动游标至当前遍历的行
            while(resultSet.next()){
                //读取行记录内容
                String user_id = resultSet.getString("req_id");
                String user_name = resultSet.getString("equip_name");
                String user_password = resultSet.getString("equip_id");
                String user_title = resultSet.getString("equip_series");
                String user_tele = resultSet.getString("problem");
                String user_auth = resultSet.getString("status");
                //转换为对象
                LEMIS_Maintain check = new LEMIS_Maintain();
                check.setReq_id(user_id);
                check.setEquip_name(user_name);
                check.setEquip_no(user_password);
                check.setEquip_series(user_title);
                check.setProblem(user_tele);
                check.setStatus(user_auth);
                //加入集合对象results
                results.add(check);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DataBaseUtil.close(connection,preparedStatement,null);
        }

        return results;
    }



    public void delete(String req_id)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "delete from maintain where req_id='"+req_id+"'";
        try {
            //TODO Not done yet
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            int update = preparedStatement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }
    public void deleteNull()throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "delete from maintain where req_id='"+null+"'";
        try {
            //TODO Not done yet
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            int update = preparedStatement.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }

}
