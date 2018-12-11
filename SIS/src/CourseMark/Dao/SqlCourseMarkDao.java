/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseMark.Dao;

import Course.Model.Course;
import Sql.MySql;
import Student.Dao.SqlStudentDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidt
 */
public class SqlCourseMarkDao implements  CourseMarkDao{
    private static SqlCourseMarkDao instance;
    
    private static final String TABLE_COURSE_MARK="coursemark";
    private static final String COLUMN_STUDENT_ID="Student_ID";
    private static final String COLUMN_COURSE_ID="Course_ID";
    private static final String COLUMN_TERM="Term";
    private static final String COLUMN_MID_SCORE="Mid_Score";
    private static final String COLUMN_FINAL_SCORE="Final_Score";
    private static final String COLUMN_COURSE_SCORE="Course_Score";
    
    private static final String GET_LEARNED_COURSE="SELECT "+COLUMN_COURSE_ID+" FROM "+TABLE_COURSE_MARK+" WHERE "+COLUMN_STUDENT_ID+"=?";
    public static SqlCourseMarkDao getInstance(){
        if(instance==null)
            instance= new SqlCourseMarkDao();
        return instance;
    }
    @Override
    public List<Course> getLearnedCourse(String StudentID) {
        List<Course> listLearnedCourse= new ArrayList<>();
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_LEARNED_COURSE);
            pst.setString(1, StudentID);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                listLearnedCourse.add(course);
            }
            return listLearnedCourse;
        } catch (SQLException ex) {
            Logger.getLogger(SqlStudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
