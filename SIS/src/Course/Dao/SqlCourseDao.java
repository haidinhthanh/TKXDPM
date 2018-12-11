/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Dao;

import Course.Model.Course;
import Sql.MySql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidt
 */
public class SqlCourseDao implements CourseDao{
    private static SqlCourseDao instance;
    
    private static final String TABLE_COURSE="course";
    private static final String COLUMN_COURSE_ID="Course_ID";
    private static final String COLUMN_COURSE_NAME="Course_Name";
    private static final String COLUMN_CREDIT="Credit";
    private static final String COLUMN_COURSE_CONDITION="Course_Condition";
    private static final String COLUMN_COURSE_TYPE="Course_Type";
    private static final String COLUMN_PROGRAM_ID="Program_ID";
    
    private static final String GET_COURSE_BY_ID="SELECT * FROM "+TABLE_COURSE+" WHERE "+COLUMN_COURSE_ID+"=?";
    private static final String GET_COURSE_BY_NAME="SELECT * FROM "+TABLE_COURSE+" WHERE "+COLUMN_COURSE_NAME+"=?";
    private static final String GET_LIST_COURSE_BY_LIST_COURSE_ID="SELECT * FROM "+TABLE_COURSE+" WHERE ";
    private static final String GET_ALL_COURSE="SELECT * FROM "+TABLE_COURSE;
    private static final String FIND_COURSE="SELECT * FROM "+TABLE_COURSE+" WHERE ";
    private static final String CHECK_EXIST_COURSE_ID= "SELECT * FROM "+TABLE_COURSE+" WHERE "+COLUMN_COURSE_ID+"=?";
    private static final String INSERT_NEW_COURSE="INSERT INTO "+TABLE_COURSE+"("+COLUMN_COURSE_ID+","+COLUMN_COURSE_NAME+","+COLUMN_CREDIT+","+COLUMN_COURSE_CONDITION+","+COLUMN_COURSE_TYPE+","+COLUMN_PROGRAM_ID+")"
                                                       +" VALUES (?,?,?,?,?,?)"; 
    public static SqlCourseDao getInstance(){
        if(instance==null)
            instance= new SqlCourseDao();
        return instance;
    }
    @Override
    public Course getCourseById(String CourseId){
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_COURSE_BY_ID);
            pst.setString(1, CourseId);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCourseType(rs.getString(COLUMN_COURSE_TYPE));
                course.setCourseCondition(rs.getString(COLUMN_COURSE_CONDITION));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                course.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Course> getListCourseByListCourseId(String[] listId) {
        List<Course> listCourse= new ArrayList<>();
        String query= GET_LIST_COURSE_BY_LIST_COURSE_ID;
        for(int i=0;i<listId.length;i++){
            if(i!=listId.length-1)
                query+= COLUMN_COURSE_ID+"='"+listId[i]+"' or ";
            else
                query+= COLUMN_COURSE_ID+"='"+listId[i]+"';";
        }
        try {
            Connection c= MySql.getInstance().getConnection();
            Statement st= c.createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCourseCondition(rs.getString(COLUMN_COURSE_CONDITION));
                course.setCourseType(rs.getString(COLUMN_COURSE_TYPE));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                course.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                listCourse.add(course);
            }     
            return listCourse;
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<Course> getAllCourse(){
        List<Course> listCourse= new ArrayList<>();
        try {
            Connection c= MySql.getInstance().getConnection();
            ResultSet rs= c.createStatement().executeQuery(GET_ALL_COURSE);
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCourseCondition(rs.getString(COLUMN_COURSE_CONDITION));
                course.setCourseType(rs.getString(COLUMN_COURSE_TYPE));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                course.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                listCourse.add(course);
            }
            return listCourse;
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Course> findCourse(String courseId, String courseName, int typeSearch) {
        try {
            String findQuery="";
            switch (typeSearch) {
                case 1:
                {
                    findQuery= FIND_COURSE+COLUMN_COURSE_ID+" like ?";
                    break;
                }
                case 2:
                {
                    findQuery= FIND_COURSE+COLUMN_COURSE_NAME+" like ?";
                    break;
                }
                default:
                {
                    findQuery= FIND_COURSE+COLUMN_COURSE_NAME+" like ? AND "+COLUMN_COURSE_ID+" like ?";
                    break;
                }
            }
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(findQuery);
            switch (typeSearch) {
                case 1:
                {
                    pst.setString(1, "%"+courseId+"%");
                    break;
                }
                case 2:
                {
                    pst.setString(1,"%"+ courseName+"%");
                    break;
                }
                default:
                {
                    pst.setString(2, "%"+courseId+"%");
                    pst.setString(1, "%"+courseName+"%");
                    break;
                }
            }
            ResultSet rs=pst.executeQuery();
            List<Course> listCourse= new ArrayList<>();
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCourseType(rs.getString(COLUMN_COURSE_TYPE));
                course.setCourseCondition(rs.getString(COLUMN_COURSE_CONDITION));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                course.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                listCourse.add(course);
            }
            return listCourse;
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int checkExistCourseId(String courseId) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(CHECK_EXIST_COURSE_ID);
            pst.setString(1, courseId);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                return 4;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
            return 5;
        }
        return 0;
    }

    @Override
    public int AddNewCourse(Course course) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst=c.prepareStatement(INSERT_NEW_COURSE);
            pst.setString(1,course.getCourseID());
            pst.setString(2,course.getCourseName());
            pst.setInt(3,course.getCredit());
            pst.setString(4,course.getCourseCondition());
            pst.setString(5,course.getCourseType());
            pst.setString(6,course.getProgramId());
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    @Override
    public Course getCourseByCourseName(String CourseName) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst=c.prepareStatement(GET_COURSE_BY_NAME);
            pst.setString(1, CourseName);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                Course course= new Course();
                course.setCourseID(rs.getString(COLUMN_COURSE_ID));
                course.setCourseName(rs.getString(COLUMN_COURSE_NAME));
                course.setCourseCondition(rs.getString(COLUMN_COURSE_CONDITION));
                course.setCourseType(rs.getString(COLUMN_COURSE_TYPE));
                course.setCredit(rs.getInt(COLUMN_CREDIT));
                course.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
