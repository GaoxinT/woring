package com.gx.woring.util;

/**
 * Created by Woring on 18-10-26.
 */

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlUtil {

    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://183.215.2.237:50890/woring";
    private static final String PASSWORD = "qqwq1121";
    //private static final String URL = "jdbc:mysql://192.168.0.249:3306/test";
    //private static final String PASSWORD = "root";

    /**
     * 选择连接数据库
     * @param url
     * @param user
     * @param password
     * @return
     */
    public static Connection openConnection(String url, String user, String password) {
        Connection conn = null;
        try {
            final String DRIVER_NAME = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
            conn = null;
        }

        return conn;
    }

    /**
     * 直接连接数据库
     * @return
     */
    public static Connection openConnectionByStatic() {
        Connection conn = null;
        try {
            final String DRIVER_NAME = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            conn = null;
        } catch (SQLException e) {
            conn = null;
        }

        return conn;
    }

    /**
     * 查询
     * @param conn
     * @param sql
     */
    public static void query(Connection conn, String sql) {

        if (conn == null) {
            return;
        }

        Statement statement = null;
        ResultSet result = null;

        try {
            statement = conn.createStatement();
            result = statement.executeQuery(sql);
            if (result != null && result.first()) {
                int idColumnIndex = result.findColumn("id");
                int nameColumnIndex = result.findColumn("name");
                while (!result.isAfterLast()) {
                    System.out.println("------------------");
                    System.out.print("id " + result.getString(idColumnIndex) + "\t");
                    System.out.println("name " + result.getString(nameColumnIndex));
                    result.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                    result = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }

            } catch (SQLException sqle) {

            }
        }
    }

    public static boolean execSQL(Connection conn, String sql) {
        boolean execResult = false;
        if (conn == null) {
            return execResult;
        }

        Statement statement = null;

        try {
            statement = conn.createStatement();
            if (statement != null) {
                execResult = statement.execute(sql);
            }
        } catch (SQLException e) {
            execResult = false;
        }

        return execResult;
    }

    public static boolean execSQLNew(String sql) {
        boolean execResult = false;
        Connection conn = openConnection(URL, USER, PASSWORD);
        if (conn == null) {
            return execResult;
        }

        Statement statement = null;

        try {
            statement = conn.createStatement();
            if (statement != null) {
                execResult = statement.execute(sql);
            }
        } catch (SQLException e) {
            execResult = false;
            Log.d("-------------",e.getMessage());
        }

        return execResult;
    }
}
