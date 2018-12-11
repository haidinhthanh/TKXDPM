/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * This class connect to data base server 
 * @author haidt
 */
public class MySql  {
    private static MySql instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://127.0.0.1:3307/";
    private static final String DATABASE_NAME = "sis?useUnicode=true&characterEncoding=utf-8";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "";
    /**
     * This method connect to DB server use diver
     * @author haidt
     * @throws SQLException if connect to DB server fail
     * @throws ClassNotFoundException if don't found driver
     * @throws InstantiationException if don't get instance
     * @throws IllegalAccessException if can't access instance
     */  
    private MySql() throws SQLException {
        try {
            Class.forName(DRIVER).newInstance();
            this.connection = DriverManager.getConnection(URL + DATABASE_NAME, USER_NAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        } catch (InstantiationException | IllegalAccessException ex) {
            System.out.println("Database Connection Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
    /**
     * This method instance object MySql
     * if null initialization object MySql
     * @author haidt
     * @return object MySql connect to DB
     * @throws SQLException if connect to DB server fail
     */
    public static MySql getInstance() throws SQLException {
        if (instance == null) {
            instance = new MySql();
        } else if (instance.getConnection().isClosed()) {
            instance = new MySql();
        }
        return instance;
    }
}
