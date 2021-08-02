package com.unicorn.lemis.model.dao;

import com.unicorn.lemis.entity.LEMIS_Maintain;
import com.unicorn.lemis.entity.LEMIS_Request;
import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.model.feature.TechEdit;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.view.feature.panel.CheckPanel;
import com.unicorn.lemis.view.feature.panel.WorkerPanel;

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
 * @date 2021/6/24 20:46
 */

public class CheckDataAccessObject {

    private DataBaseUtil dataBaseUtil;
    public CheckDataAccessObject(){
        dataBaseUtil = new DataBaseUtil();
    }

    /**
     * @description Edit or update check data
     * @param [check]
     * @return void
     */

    public void update(LEMIS_Request check)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        String req_id = CheckPanel.greq_id;
        //TODO sql command 2021/6/18
        String sql = "update checklist set status='"+check.getStatus()+ "'WHERE req_id='"+req_id+"'";
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

    public void updateStatus(LEMIS_Request req)throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        String index = "Wating";
        String req_id = WorkerPanel.greq_id;
        //TODO sql command 2021/6/18
        String sql = "update checklist set status='"+req.setNewStatus(index)+"' WHERE req_id='"+req_id+"'";
        try{
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            int update = preparedStatement.executeUpdate(sql);
            LOGGER.info("update status successful");
            // TODO: 2021/6/18 it seems like i have something to do?
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }

    /**
     * @description Delete user data by req_id
     * @param [req_id]
     * @return void
     */

    public void delete(String req_id)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "delete from checklist where req_id='"+req_id+"'";
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
     * @description Query checklist data
     * @param [example]
     * @return java.util.ArrayList<com.unicorn.lemis.entity.LEMIS_Request>
     */
// TODO: 2021/6/23 Bug fixed
    public List<LEMIS_Request> queryChecklist(LEMIS_Request example)throws SQLException{
        List<LEMIS_Request> results = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        //声明存放占位符?对应值的能动态添加元素的链表
        List<Object> params=new ArrayList<Object>();
        int index = 1;
        String sql="select * from checklist where 1=1";
        try{
            connection= getConn();
            preparedStatement=connection.prepareStatement(sql);
            //拼接SQL语句
            if(example!=null){
                if(example.getRequest_id()!=null&&!"".equals(example.getRequest_id().trim())) {
                    sql = sql + " and req_id =?";
                    params.add(example.getRequest_id());
                }
                if(example.getEquip_name()!=null&&!"".equals(example.getEquip_name().trim())){
                    sql=sql+" and equip_name = ?";
                    params.add(example.getEquip_name()+"%");
                }
                if(example.getEquip_no()!=null&&!"".equals(example.getEquip_no().trim())){
                    sql=sql+" and equip_no = ?";
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
                if(example.getLab()!=null&&!"".equals(example.getLab().trim())){
                    sql=sql+" and lab = ?";
                    params.add(example.getLab());
                }
                if(example.getStatus()!=null&&!"".equals(example.getStatus().trim())){
                    sql=sql+" and status = ?";
                    params.add(example.getStatus());
                }
                if(example.getReq_repair_man()!=null&&!"".equals(example.getReq_repair_man().trim())){
                    sql=sql+" and req_repair_man = ?";
                    params.add(example.getReq_repair_man());
                }

            }
            //执行sql语句
            resultSet=preparedStatement.executeQuery();
            //遍历结果集results
            results=new ArrayList<LEMIS_Request>();
            //调用next()移动游标至当前遍历的行
            while(resultSet.next()){
                //读取行记录内容
                String user_id = resultSet.getString("req_id");
                String user_name = resultSet.getString("equip_name");
                String user_password = resultSet.getString("equip_no");
                String user_title = resultSet.getString("equip_series");
                String user_tele = resultSet.getString("problem");
                String user_dept = resultSet.getString("lab");
                String user_auth = resultSet.getString("status");
                String user_status = resultSet.getString("req_repair_man");
                //转换为对象
                LEMIS_Request check=new LEMIS_Request();
                check.setRequest_id(user_id);
                check.setEquip_name(user_name);
                check.setEquip_no(user_password);
                check.setEquip_series(user_title);
                check.setProblem(user_tele);
                check.setLab(user_dept);
                check.setStatus(user_auth);
                check.setReq_repair_man(user_status);
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
    public List<LEMIS_Request> queryCheck(String status){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        List<LEMIS_Request> list=new ArrayList<LEMIS_Request>();
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from checklist where status=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, status);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String user_id = resultSet.getString("req_id");
                String user_name = resultSet.getString("equip_name");
                String user_password = resultSet.getString("equip_no");
                String user_title = resultSet.getString("equip_series");
                String user_tele = resultSet.getString("problem");
                String user_dept = resultSet.getString("lab");
                String user_auth = resultSet.getString("status");
                String user_status = resultSet.getString("req_repair_man");
                LEMIS_Request check=new LEMIS_Request();
                check.setRequest_id(user_id);
                check.setEquip_name(user_name);
                check.setEquip_no(user_password);
                check.setEquip_series(user_title);
                check.setProblem(user_tele);
                check.setLab(user_dept);
                check.setStatus(user_auth);
                check.setReq_repair_man(user_status);
                list.add(check);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            DataBaseUtil.close(connection,preparedStatement,resultSet);
        }

        return list;
    }
/**
 * 插入维修表
 */
    public void insert(LEMIS_Maintain req)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        String index = "Approve";
        //TODO sql command 2021/6/18
        String sql = "insert into maintain(req_id,equip_name,equip_id,equip_series,problem,status)values('"+req.getReq_id()+"','"+req.getEquip_name()+"','"+req.getEquip_no()+"','"+req.getEquip_series()+"','"+req.getProblem()+"','"+req.setNewStatus(index)+"')";
        try{
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            LOGGER.info("insert successful");
        }catch (Exception e){
            LOGGER.info("insert fail");
            e.printStackTrace();
        }finally {
            DataBaseUtil.close(connection,preparedStatement,null);
        }
    }
    public void insertCheck(LEMIS_Request req)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        String index = "Waiting";
        //TODO sql command 2021/6/18
        String sql = "insert into checklist(req_id,equip_name,equip_no,equip_series,problem,req_repair_man,status,lab)values('"+req.getRequest_id()+"','"+req.getEquip_name()+"','"+req.getEquip_no()+"','"+req.getEquip_series()+"','"+req.getProblem()+"','"+req.getReq_repair_man()+"','"+req.setNewStatus(index)+"','"+req.getLab()+"')";
        try{
            connection = getConn();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(sql);
            LOGGER.info("insert successful");
        }catch (Exception e){
            LOGGER.info("insert fail");
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
        String sql = "delete from checklist where req_id='"+null+"'";
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

}
