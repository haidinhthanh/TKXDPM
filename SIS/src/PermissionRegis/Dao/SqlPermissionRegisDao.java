/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionRegis.Dao;

import Sql.MySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidt
 */
public class SqlPermissionRegisDao implements PermissionRegisDao{
    private static SqlPermissionRegisDao instance;
    private static final String TABLE_PERMISSION_REGISTER="permissionregister";
    private static final String COLUMN_ID ="Id";
    private static final String COLUMN_NAME_PERMISSION="Name_Permission";
    private static final String COLUMN_DATE_START="Date_Start";
    private static final String COLUMN_DATE_END="Date_End";
    private static final String COLUMN_TERM="Term";
    
    private static final String GET_PERMISSION_REGIS_COURSE="SELECT * FROM "+TABLE_PERMISSION_REGISTER+" WHERE "+COLUMN_NAME_PERMISSION+"='DKHP'"+" AND "+"?"+" BETWEEN "+COLUMN_DATE_START+" AND "+COLUMN_DATE_END;
    private static final String GET_PERMISSION_REGIS_COURSE_BY_TERM="SELECT * FROM "+TABLE_PERMISSION_REGISTER+ " WHERE "+COLUMN_TERM+"=? AND "+COLUMN_NAME_PERMISSION+"='DKHP'";
    private static final String GET_PERMISSION_REGIS_CLASS_BY_TERM="SELECT * FROM "+TABLE_PERMISSION_REGISTER+ " WHERE "+COLUMN_TERM+"=? AND "+COLUMN_NAME_PERMISSION+"='DKL'";
    private static final String GET_PERMISSION_REGIS_CLASS="SELECT * FROM "+TABLE_PERMISSION_REGISTER+" WHERE "+COLUMN_NAME_PERMISSION+"='DKL'"+" AND "+"?"+" BETWEEN "+COLUMN_DATE_START+" AND "+COLUMN_DATE_END;
    public static SqlPermissionRegisDao getInstance(){
        if(instance==null){
            instance= new SqlPermissionRegisDao();
        }
        return instance;
    }
    @Override
    public boolean getPermissionRegisCourse(Date date) {
        String dateInstance= new SimpleDateFormat("yyyy-MM-dd").format(date);
        try {
            Connection c = MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_PERMISSION_REGIS_COURSE);
            pst.setString(1, dateInstance);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SqlPermissionRegisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public boolean getPermissionRegisCourse(String term){
        try {
            Connection c = MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_PERMISSION_REGIS_COURSE_BY_TERM);
            pst.setString(1, term);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SqlPermissionRegisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean getPermissionRegisClass(Date date) {
        String dateInstance= new SimpleDateFormat("yyyy-MM-dd").format(date);
        try {
            Connection c = MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_PERMISSION_REGIS_CLASS);
            pst.setString(1, dateInstance);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SqlPermissionRegisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean getPermissionRegisClass(String term) {
        try {
            Connection c = MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_PERMISSION_REGIS_CLASS_BY_TERM);
            pst.setString(1, term);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SqlPermissionRegisDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
