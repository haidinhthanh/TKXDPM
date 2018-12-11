/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.Dao;

import Sql.MySql;
import Student.Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is data access class for entity Student
 * @author haidt
 */
public class SqlStudentDao implements StudentDao{
    private static SqlStudentDao instance;
    //table student
    private static final String COLUMN_STUDENT_ID="Student_ID";
    private static final String COLUMN_NAME="Name";
    private static final String COLUMN_GENDER="Gender";
    private static final String COLUMN_BIRTH="Birth";
    private static final String COLUMN_ADDRESS="Address";
    private static final String COLUMN_EMAIL="Email";
    private static final String COLUMN_PHONE="Phone";
    private static final String COLUMN_DATE_START="Date_Start";
    private static final String COLUMN_PROGRAM_ID="Program_ID";
    
    private static final String GET_STUDENT_BY_ID="SELECT * FROM student WHERE student.Student_ID=?;";
    /**
     * This method get instance object SqlStudentDao
     * if null initialization object SqlStudentDao
     * @author haidt
     * @return instance object of SqlStudentDao
     */
    public static SqlStudentDao getInstance(){
        if(instance==null){
            instance= new SqlStudentDao();
        }
        return instance;
    }
    /**
     * This method get student information by student ID like "20151178"
     * @author haidt
     * @param StudentId
     * @throws SQL Exception if don't have connection to sever data base
     * @return an object Student
     */
    @Override
    public Student getStudentByID(String StudentId) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_STUDENT_BY_ID);
            pst.setString(1, StudentId);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Student student= new Student();
                student.setStudentID(rs.getString(COLUMN_STUDENT_ID));
                student.setName(rs.getString(COLUMN_NAME));
                student.setGender(rs.getString(COLUMN_GENDER));
                student.setBirth(rs.getDate(COLUMN_BIRTH));
                student.setAddress(rs.getString(COLUMN_ADDRESS));
                student.setEmail(rs.getString(COLUMN_EMAIL));
                student.setPhone(rs.getString(COLUMN_PHONE));
                student.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                student.setDateStart(rs.getDate(COLUMN_DATE_START));
                return student;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
