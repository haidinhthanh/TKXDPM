/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classroom.Dao;

import Classroom.Model.Classroom;
import Sql.MySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidt
 */
public class SqlClassroomDao implements ClassroomDao{
    private static SqlClassroomDao instance;
    
    private final static String TABLE_CLASSROOM="classroom";
    private final static String COLUMN_CLASS_ID="Class_ID";
    private final static String COLUMN_COURSE_ID="Course_ID";
    private final static String COLUMN_COURSE_NAME="Course_Name";
    private final static String COLUMN_CLASS_TYPE="Class_Type";
    private final static String COLUMN_CLASS_TIME="Class_Time";
    private final static String COLUMN_PLACE="Place";
    private final static String COLUMN_MAX_STUDENT="MaxStudent";
    private final static String COLUMN_CLASS_STATE="ClassState";
    
    private final static String GET_CLASSROOM_BY_ID="SELECT * FROM "+TABLE_CLASSROOM+" WHERE "+COLUMN_CLASS_ID+"=?;";
    public static SqlClassroomDao getInstance(){
        if(instance==null)
            instance = new SqlClassroomDao();
        return instance;
    }
    @Override
    public Classroom getClassroomById(String ClassRoomId) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_CLASSROOM_BY_ID);
            pst.setString(1, ClassRoomId);
            ResultSet rs=pst.executeQuery();
            while (rs.next()){
                Classroom classroom = new Classroom();
                classroom.setClassId(rs.getString(COLUMN_CLASS_ID));
                classroom.setClassType(rs.getString(COLUMN_CLASS_TYPE));
                classroom.setCourseId(rs.getString(COLUMN_COURSE_ID));
                classroom.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                classroom.setPlace(rs.getString(COLUMN_PLACE));
                classroom.setTime(rs.getString(COLUMN_CLASS_TIME));
                classroom.setMaxStudent(rs.getInt(COLUMN_MAX_STUDENT));
                classroom.setState(rs.getString(COLUMN_CLASS_STATE));
                return classroom;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlClassroomDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
    
}
