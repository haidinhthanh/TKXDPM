/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterCourse.Dao;

import Course.Model.Course;
import Register.RegisterCourse.Model.SignCourseDetail;
import Sql.MySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is data access class for entity SignCourseDetail
 * @author haidt
 */
public class SqlSignCourseDetailDao implements SignCourseDetailDao{
    private static SqlSignCourseDetailDao instance;
    
    private static final String TABLE_SIGN_COURSE="signcoursedetail";
    private static final String TABLE_COURSE="course";
    private static final String COLUMN_COURSE_ID="Course_ID";
    private static final String COLUMN_STUDENT_ID="Student_ID";
    private static final String COLUMN_TIME_REGISTER="Time_Register";
    private static final String COLUMN_STATUS="Status";
    private static final String COLUMN_TERM="Term";
    private static final String COLUMN_COURSE_NAME="Course_Name";
    private static final String COLUMN_CREDIT="Credit";
    
    private static final String ADD_SIGN_COURSE_DETAIL="INSERT INTO "+TABLE_SIGN_COURSE+"("+COLUMN_COURSE_ID+","+COLUMN_STUDENT_ID+","+COLUMN_TIME_REGISTER+","+COLUMN_STATUS+","+COLUMN_TERM+")"
    + " VALUES (?,?,?,?,?)";
    private static final String DELETE_SIGN_COURSE_DETAIL="DELETE FROM "+TABLE_SIGN_COURSE+" WHERE "+COLUMN_COURSE_ID+"=?"+" AND "+COLUMN_STUDENT_ID+"=?";
    private static final String GET_ALL_SIGN_COURSE_DETAIL="SELECT "+TABLE_COURSE+"."+COLUMN_COURSE_NAME+","+TABLE_SIGN_COURSE+"."+COLUMN_COURSE_ID+","+TABLE_COURSE+"."+COLUMN_CREDIT+
            " FROM "+TABLE_SIGN_COURSE+" JOIN "+TABLE_COURSE +" ON "+ TABLE_SIGN_COURSE+"."+COLUMN_COURSE_ID+"="+TABLE_COURSE+"."+COLUMN_COURSE_ID+
            " WHERE "+TABLE_SIGN_COURSE+"."+COLUMN_STUDENT_ID+"=?"+" AND "+ TABLE_SIGN_COURSE+"."+COLUMN_TERM+"=?";
    private static final String GET_SIGN_SUCESS_COURSE_LIST="SELECT * FROM "+TABLE_SIGN_COURSE+" WHERE "+COLUMN_STUDENT_ID+"=? AND "+COLUMN_TERM+"=?";
    
    public static SqlSignCourseDetailDao getInstance(){
        if(instance==null)
            instance= new SqlSignCourseDetailDao();
        return instance;
    }
    @Override
    public int addSignCourseDetail(Course signCourse,String StudentID,String Term) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(ADD_SIGN_COURSE_DETAIL);
            Date date= new Date();
            pst.setString(1,signCourse.getCourseID());
            pst.setString(2,StudentID);
            pst.setDate(3,new java.sql.Date(date.getTime()));
            pst.setString(4,"ĐKTC");
            pst.setString(5,Term);
            pst.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            return 1;
        }        
    }

    @Override
    public int deleteSignCourseDetail(Course signCourse, String StudentID) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(DELETE_SIGN_COURSE_DETAIL);
            pst.setString(1,signCourse.getCourseID());
            pst.setString(2,StudentID);
            pst.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            return 1;
        }        
    }

    @Override
    public List<Course> getAllSignCourseDetailByStudentID(String StudentID,String Term) {
        try {
            List<Course> lC= new ArrayList<>();
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst=c.prepareStatement(GET_ALL_SIGN_COURSE_DETAIL);
            pst.setString(1, StudentID);
            pst.setString(2,Term);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                lC.add(course);
            }
            return lC;
        } catch (SQLException ex) {
            
        }
        return null;
    }

    @Override
    public List<SignCourseDetail> getSignSucessCourseList(String Term, String StudentID) {
        try {
            List<SignCourseDetail> listSignSucessCourse= new ArrayList<>();
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst=c.prepareCall(GET_SIGN_SUCESS_COURSE_LIST);
            pst.setString(1,StudentID);
            pst.setString(2,Term);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                SignCourseDetail sCD= new SignCourseDetail();
                sCD.setCourseID(rs.getString(COLUMN_COURSE_ID));
                sCD.setTerm(rs.getString(COLUMN_TERM));
                listSignSucessCourse.add(sCD);
            }
            return listSignSucessCourse;
        } catch (SQLException ex) {
            Logger.getLogger(SqlSignCourseDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
