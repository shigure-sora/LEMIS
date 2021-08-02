package com.unicorn.lemis.model.dao;

import com.unicorn.lemis.entity.LEMIS_Equip;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.model.feature.EquipEdit;
import com.unicorn.lemis.view.feature.panel.WorkerPanel;

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
 * @date 2021/6/17 18:52
 */

public class EquipDataAccessObject {

    private DataBaseUtil dataBaseUtil;
    public EquipDataAccessObject(){
        dataBaseUtil = new DataBaseUtil();
    }

    /**
     * @description insert equip data
     * @param [user]
     * @return void
     */
    public void insert(LEMIS_Equip equip)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "insert into equipment(equip_no,equip_name,equip_lab,manufacturing_date,expiring_date,manufactory,equip_series,status)values('"+equip.getEquip_no()+"','"+equip.getEquip_name()+"','"+equip.getEquip_lab()+"','"+equip.getManufacturing_date()+"','"+equip.getExpiring_date()+"','"+equip.getManufactory()+"','"+equip.getEquip_series()+"','"+equip.getStatus()+"')";
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
     * @description Edit or update equip data
     * @param [user]
     * @return void
     */

    public void update(LEMIS_Equip equip)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        String equip_no = EquipEdit.eno;
        //TODO sql command 2021/6/18
        String sql = "update equipment set equip_lab='"+equip.getEquip_lab()+ "',status='"+equip.getStatus()+"',problem='"+equip.getProblem()+"',req_repair_man='"+equip.getReq_repair_man()+"',worker_name='"+equip.getWorker_name()+"'WHERE equip_no='"+equip_no+"'";
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
     * @description Worker update equip data
     * @param [user]
     * @return void
     */

    public void workerUpdate(LEMIS_Equip equip)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        String equip_no = WorkerPanel.gequip_id;
        //TODO sql command 2021/6/18
        String sql = "update equipment set status='"+equip.getStatus()+"',problem='"+equip.getProblem()+"',req_repair_man='"+equip.getReq_repair_man()+"',worker_name='"+equip.getWorker_name()+"'WHERE equip_no='"+equip_no+"'";
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
     * @description Delete equip data by equip_no
     * @param [equip_no]
     * @return void
     */

    public void delete(String equip_no)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        int index = 1;
        //TODO sql command 2021/6/18
        String sql = "delete from equipment where equip_no='"+equip_no+"'";
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
     * @description Query equip data
     * @param [example]
     * @return java.util.ArrayList<com.unicorn.lemis.entity.LEMIS_Equip>
     */
// TODO: 2021/6/23 Bug fixed
    public List<LEMIS_Equip> queryEquip(LEMIS_Equip example)throws SQLException{
        List<LEMIS_Equip> results = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        //声明存放占位符?
        List<Object> params=new ArrayList<Object>();
        int index = 1;
        String sql="select * from equipment where 1=1";
        try{
            connection= getConn();
            preparedStatement=connection.prepareStatement(sql);
            //拼接SQL语句
            if(example!=null){
                if(example.getEquip_no()!=null&&!"".equals(example.getEquip_no().trim())) {
                    sql = sql + " and equip_no =?";
                    params.add(example.getEquip_no());
                }
                if(example.getEquip_name()!=null&&!"".equals(example.getEquip_name().trim())){
                    sql=sql+" and equip_name = ?";
                    params.add(example.getEquip_name()+"%");
                }
                if(example.getEquip_lab()!=null&&!"".equals(example.getEquip_lab().trim())){
                    sql=sql+" and equip_lab = ?";
                    params.add(example.getEquip_lab());
                }
                if(example.getManufacturing_date()!=null&&!"".equals(example.getManufacturing_date().trim())){
                    sql=sql+" and  manufacturing_date = ?";
                    params.add(example.getManufacturing_date());
                }
                if(example.getEquip_series()!=null&&!"".equals(example.getEquip_series().trim())){
                    sql=sql+" and expiring_date = ?";
                    params.add(example.getEquip_series());
                }
                if(example.getManufactory()!=null&&!"".equals(example.getManufactory().trim())){
                    sql=sql+" and manufactory = ?";
                    params.add(example.getManufactory());
                }
                if(example.getEquip_series()!=null&&!"".equals(example.getEquip_series().trim())){
                    sql=sql+" and equip_series = ?";
                    params.add(example.getEquip_series());
                }
                if(example.getStatus()!=null&&!"".equals(example.getStatus().trim())){
                    sql=sql+" and status = ?";
                    params.add(example.getStatus());
                }
                if(example.getProblem()!=null&&!"".equals(example.getProblem().trim())){
                    sql=sql+" and problem = ?";
                    params.add(example.getProblem());
                }
                if(example.getReq_repair_man()!=null&&!"".equals(example.getReq_repair_man().trim())){
                    sql=sql+" and req_repair_man = ?";
                    params.add(example.getEquip_series());
                }
                if(example.getWorker_name()!=null&&!"".equals(example.getWorker_name().trim())){
                    sql=sql+" and worker_name = ?";
                    params.add(example.getWorker_name());
                }

            }
            //执行sql语句
            resultSet=preparedStatement.executeQuery();
            //遍历结果集results
            results=new ArrayList<LEMIS_Equip>();
            //调用next()移动游标至当前遍历的行
            while(resultSet.next()){
                //读取行记录内容
                String equip_no = resultSet.getString("equip_no");
                String equip_name = resultSet.getString("equip_name");
                String equip_lab = resultSet.getString("equip_lab");
                String manufacturing_date = resultSet.getString("manufacturing_date");
                String expiring_date = resultSet.getString("expiring_date");
                String manufactory = resultSet.getString("manufactory");
                String equip_series = resultSet.getString("equip_series");
                String status = resultSet.getString("status");
                String problem = resultSet.getString("problem");
                String req_repair_man = resultSet.getString("req_repair_man");
                String worker_name = resultSet.getString("worker_name");
                //转换为对象
                LEMIS_Equip equip = new LEMIS_Equip();
                equip.setEquip_no(equip_no);
                equip.setEquip_name(equip_name);
                equip.setEquip_lab(equip_lab);
                equip.setManufacturing_date(manufacturing_date);
                equip.setExpiring_date(expiring_date);
                equip.setManufactory(manufactory);
                equip.setEquip_series(equip_series);
                equip.setStatus(status);
                equip.setProblem(problem);
                equip.setReq_repair_man(req_repair_man);
                equip.setWorker_name(worker_name);
                //加入集合对象results
                results.add(equip);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            DataBaseUtil.close(connection,preparedStatement,null);
        }

        return results;
    }

    /**
     * @description QueryProblemEquip by status
     * @param []
     * @return java.util.List<com.unicorn.lemis.entity.LEMIS_User>
     */

    public List<LEMIS_Equip> queryStatus(String status){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        List<LEMIS_Equip> list=new ArrayList<LEMIS_Equip>();
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from equipment where status=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, status);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String equip_no = resultSet.getString("equip_no");
                String equip_name = resultSet.getString("equip_name");
                String equip_lab = resultSet.getString("equip_lab");
                String manufacturing_date = resultSet.getString("manufacturing_date");
                String expiring_date = resultSet.getString("expiring_date");
                String manufactory = resultSet.getString("manufactory");
                String equip_series = resultSet.getString("equip_series");
                String problem = resultSet.getString("problem");
                String status1 = resultSet.getString("status");
                String req_repair_man = resultSet.getString("req_repair_man");
                String worker_name = resultSet.getString("worker_name");
                LEMIS_Equip equip = new LEMIS_Equip();
                equip.setEquip_no(equip_no);
                equip.setEquip_name(equip_name);
                equip.setEquip_lab(equip_lab);
                equip.setManufacturing_date(manufacturing_date);
                equip.setExpiring_date(expiring_date);
                equip.setManufactory(manufactory);
                equip.setEquip_series(equip_series);
                equip.setStatus(status1);
                equip.setProblem(problem);
                equip.setReq_repair_man(req_repair_man);
                equip.setWorker_name(worker_name);
                list.add(equip);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            DataBaseUtil.close(connection,preparedStatement,resultSet);
        }

        return list;
    }

    /**
     * @description Randomly generated equip_no
     * @param [equip]
     * @param equip
     * @return java.lang.String
     */
    public String randomid(String equip)throws Exception{
        String equip_no = "0";
        Random random = new Random();
        for(int i=0;i<=1;i++){
            equip_no = String.valueOf(random.nextInt(400000000) + 316381099);
        }
        LOGGER.info("random successful");
        return equip_no;
    }

    /**
     * @description Randomly generated equip code
     * @param [equip]
     * @return java.lang.String
     */

    public String randomcode(LEMIS_Equip equip)throws Exception{
        String equip_no = "0";
        Random random = new Random();
        for(int i=0;i<=1;i++){
            equip_no = String.valueOf(random.nextInt(999999) + 1);
        }
        LOGGER.info("random successful");
        return equip_no;
    }

    /**
     * @description Sequential generation of equip_no
     * @param [equip]
     * @param equip
     * @return java.lang.String
     */
    public String genreateEquipno(String equip)throws Exception{
        int equip_no = 316381099;
        String genreated = Integer.toString(equip_no++);
        LOGGER.info("random successful");
        return genreated;
    }
    public static void init(){
        EquipDataAccessObject object = new EquipDataAccessObject();
    }
}
