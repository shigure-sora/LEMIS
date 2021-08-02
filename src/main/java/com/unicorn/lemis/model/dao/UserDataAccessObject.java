package com.unicorn.lemis.model.dao;

import com.unicorn.lemis.entity.LEMIS_User;
import com.unicorn.lemis.util.DataBaseUtil;
import com.unicorn.lemis.model.feature.TechEdit;

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
 * @date 2021/6/16 0:02
 */

public class UserDataAccessObject {
    private DataBaseUtil dataBaseUtil;
    public UserDataAccessObject(){
        dataBaseUtil = new DataBaseUtil();
    }

/**
 * @description insert user data
 * @param [user]
 * @return void
 */

// TODO: 2021/6/18 Code simplified
public void insert(LEMIS_User user)throws SQLException{
    Connection connection = null;
    PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
    String sql = "insert into user(user_id,user_name,user_password,user_title,user_tele,user_dept,user_auth,user_status,user_lab)values('"+user.getUser_id()+"','"+user.getUser_name()+"','"+user.getUser_password()+"','"+user.getUser_title()+"','"+user.getUser_tele()+"','"+user.getUser_dept()+"','"+user.getUser_auth()+"','"+user.getUser_status()+"','"+user.getUser_lab()+"')";
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
 * @description Edit or update user data
 * @param [user]
 * @return void
 */

public void update(LEMIS_User user)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        String user_id = TechEdit.uid;
        //TODO sql command 2021/6/18
        String sql = "update user set user_name='"+user.getUser_name()+ "',user_tele='"+user.getUser_tele()+"',user_dept='"+user.getUser_dept()+"',user_status='"+user.getUser_status()+"',user_lab='"+user.getUser_lab()+"'WHERE user_id='"+user_id+"'";
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
 * @description Delete user data by user_id
 * @param [user_id]
 * @return void
 */

public void delete(String user_id)throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        //TODO sql command 2021/6/18
        String sql = "delete from user where user_id='"+user_id+"'";
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
 * @description Query user data
 * @param [example]
 * @return java.util.ArrayList<com.unicorn.lemis.entity.LEMIS_User>
 */
// TODO: 2021/6/23 Bug fixed
public List<LEMIS_User> queryUser(LEMIS_User example)throws SQLException{
        List<LEMIS_User> results = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        //声明存放占位符?对应值的能动态添加元素的链表
        List<Object> params=new ArrayList<Object>();
        String sql="select * from user where 1=1";
        try{
        connection= getConn();
        preparedStatement=connection.prepareStatement(sql);
        //拼接SQL语句
        if(example!=null){
            if(example.getUser_id()!=null&&!"".equals(example.getUser_id().trim())) {
                sql = sql + " and user_id =?";
                params.add(example.getUser_id());
            }
            if(example.getUser_name()!=null&&!"".equals(example.getUser_name().trim())){
                sql=sql+" and user_name = ?";
                params.add(example.getUser_name()+"%");
            }
            if(example.getUser_password()!=null&&!"".equals(example.getUser_password().trim())){
                sql=sql+" and user_password = ?";
                params.add(example.getUser_password());
            }
            if(example.getUser_title()!=null&&!"".equals(example.getUser_title().trim())){
                sql=sql+" and user_title = ?";
                params.add(example.getUser_title());
            }
            if(example.getUser_tele()!=null&&!"".equals(example.getUser_tele().trim())){
                sql=sql+" and user_tele = ?";
                params.add(example.getUser_tele());
            }
            if(example.getUser_dept()!=null&&!"".equals(example.getUser_dept().trim())){
                sql=sql+" and user_dept = ?";
                params.add(example.getUser_dept());
            }
            if(example.getUser_auth()!=null&&!"".equals(example.getUser_auth().trim())){
                sql=sql+" and user_auth = ?";
                params.add(example.getUser_auth());
            }
        }
        //执行sql语句
            resultSet=preparedStatement.executeQuery();
        //遍历结果集results
        results=new ArrayList<LEMIS_User>();
        //调用next()移动游标至当前遍历的行
        while(resultSet.next()){
            //读取行记录内容
            String user_id = resultSet.getString("user_id");
            String user_name = resultSet.getString("user_name");
            String user_password = resultSet.getString("user_password");
            String user_title = resultSet.getString("user_title");
            String user_tele = resultSet.getString("user_tele");
            String user_dept = resultSet.getString("user_dept");
            String user_auth = resultSet.getString("user_auth");
            String user_status = resultSet.getString("user_status");
            //转换为对象
            LEMIS_User user=new LEMIS_User();
            user.setUser_id(user_id);
            user.setUser_name(user_name);
            user.setUser_password(user_password);
            user.setUser_title(user_title);
            user.getUser_tele(user_tele);
            user.setUser_dept(user_dept);
            user.setUser_auth(user_auth);
            user.getUser_status(user_status);
            //加入集合对象results
            results.add(user);
        }
    }catch(Exception e){
        e.printStackTrace();
    }finally{
            DataBaseUtil.close(connection,preparedStatement,null);
    }

    return results;
}

/**
 * @description QueryTechnician
 * @param []
 * @return java.util.List<com.unicorn.lemis.entity.LEMIS_User>
 */

    public List<LEMIS_User > queryTechnician(String title){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        List<LEMIS_User> list=new ArrayList<LEMIS_User>();
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from user where user_title=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, title);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String user_id = resultSet.getString("user_id");
                String user_name = resultSet.getString("user_name");
                String user_tele = resultSet.getString("user_tele");
                String user_dept = resultSet.getString("user_dept");
                String user_lab = resultSet.getString("user_lab");
                String user_status = resultSet.getString("user_status");
                LEMIS_User user=new LEMIS_User();
                user.setUser_id(user_id);
                user.setUser_name(user_name);
                user.setUser_tele(user_tele);
                user.setUser_dept(user_dept);
                user.setUser_lab(user_lab);
                user.setUser_status(user_status);
                list.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            DataBaseUtil.close(connection,preparedStatement,resultSet);
        }
        return list;
    }

/**
 * @description Login Authorization
 * @param [user_id, user_password]
 * @return boolean
 */
    public static boolean loginChecker(String user_id,String user_password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        boolean flag =true;
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from user where user_id=? and user_password=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2,user_password);
            //执行sql
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                flag = true;
            }else{
                flag = false;
            }
            //释放资源
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }

        return flag;
    }

/**
 * @description Authorization code check
 * @param [code, title]
 * @return boolean
 */
public static boolean checker(String code,String title) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
    ResultSet resultSet = null;
    boolean flag =true;
    try {
        connection = DataBaseUtil.getConn();
        String sql = "select * from user where user_auth=? and user_title=?";
        preparedStatement = connection.prepareStatement(sql);
        //给sql语句设置参数
        preparedStatement.setString(1, code);
        preparedStatement.setString(2,title);
        //执行sql
        resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            flag = true;
        }else{
            flag = false;
        }
        //释放资源
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    } finally {
        DataBaseUtil.close(connection, preparedStatement, resultSet);
    }

    return flag;
}

/**
 * @description Login switcher
 * @param [user_id]
 * @return boolean
 */
public static String titleChecker(String user_id) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
    ResultSet resultSet = null;
    String user_title = null;
    try {
        connection = DataBaseUtil.getConn();
        String sql = "select * from user where user_id=?";
        preparedStatement = connection.prepareStatement(sql);
        //给sql语句设置参数
        preparedStatement.setString(1, user_id);
        //执行sql
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user_title = resultSet.getString("user_title");
        }
        //释放资源
    } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
    } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
    }
    return user_title;
}

/**
 * @description Info getter
 * @param [user_id]
 * @return java.lang.String
 */
    public static String infoGetter(String user_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        String user_name = null;
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from user where user_id=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, user_id);
            //执行sql
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user_name = resultSet.getString("user_name");
            }
            //释放资源
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
        return user_name;
    }
/**
 * @description Retrieve password
 * @param [user_id,user_tele]
 * @return java.lang.String
 */
    public static String retrievePassword(String user_id,String user_tele) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;//对象PreparedStatement有预编译的过程
        ResultSet resultSet = null;
        String user_password = null;
        try {
            connection = DataBaseUtil.getConn();
            String sql = "select * from user where user_id=? and user_tele=?";
            preparedStatement = connection.prepareStatement(sql);
            //给sql语句设置参数
            preparedStatement.setString(1, user_id);
            preparedStatement.setString(2,user_tele);
            //执行sql
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user_password = resultSet.getString("user_password");
            }
            //释放资源
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            DataBaseUtil.close(connection, preparedStatement, resultSet);
        }
        return user_password;
    }

/**
 * @description Randomly generated user_id
 * @param [user]
 * @param user
 * @return java.lang.String
 */
public String randomid(String user)throws Exception{
    String user_id = "0";
    Random random = new Random();
    for(int i=0;i<=1;i++){
        user_id = String.valueOf(random.nextInt(400000000) + 316381099);
    }
return user_id;
}

/**
 * @description Randomly generated authorization code
 * @param [user]
 * @return java.lang.String
 */

public String randomcode(LEMIS_User user)throws Exception{
        String user_auth = "0";
        Random random = new Random();
        for(int i=0;i<=1;i++){
            user_auth = String.valueOf(random.nextInt(999999) + 100000);
        }
        return user_auth;
}

/**
 * @description Sequential generation of user_id
 * @param [user]
 * @param user
 * @return java.lang.String
 */
public String genreateuserid(String user)throws Exception{
    int user_id = 316381099;
    String genreated = Integer.toString(user_id++);
    return genreated;
}
    /**public static void init(){
    UserDataAccessObject object = new UserDataAccessObject();
    }*/
}
