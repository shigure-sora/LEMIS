package com.unicorn.lemis.util;


import java.sql.*;

import static com.unicorn.lemis.Launch.LOGGER;


/**
 * @author kano_dayo
 * @date 2021/6/15 12:45
 */

public class DataBaseUtil {

    static String driverClass = null;
    static String url = null;
    static String name = null;
    static String password = null;

    //读取config.properties数据
    static {
        driverClass = PropertyUtil.getProperty("driverClass");
        url = PropertyUtil.getProperty("url");
        name = PropertyUtil.getProperty("name");
        password = PropertyUtil.getProperty("password");
    }

    // TODO: 2021/6/19 用户多线程处理模块 还没做

    public static Connection getConn() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(url,name,password);
            return connection;
        }catch (Exception a){
            a.printStackTrace();
            throw a;
        }
    }

/**
 * release resources
*/

    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        closeRs(resultSet);
        closeSt(preparedStatement);
        closeConn(connection);
    }

    private static void closeRs(ResultSet resultSet){
        try {
            if(resultSet !=null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            resultSet = null;
        }
    }

    private static void closeSt(PreparedStatement preparedStatement){
        try {
            if(preparedStatement !=null){
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            preparedStatement = null;
        }
    }

    private static void closeConn(Connection connection){
        try {
            if(connection !=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection = null;
        }
    }
}
