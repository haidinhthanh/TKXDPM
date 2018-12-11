/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterClassroom.Dao;

import Classroom.Model.Classroom;
import Register.RegisterClassroom.Model.SignClassDetail;
import Sql.MySql;
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
public class SqlSignClassDetailDao implements SignClassDetailDao{
    private static SqlSignClassDetailDao instance;
    
    private static final String TABLE_SIGN_CLASS_DETAIL="signclassdetail";
    private static final String TABLE_CLASSROOM="classroom";
    private static final String COLUMN_CLASS_ID="Class_ID";
    private static final String COLUMN_STUDENT_ID="Student_ID";
    private static final String COLUMN_TIME_REGISTER="Time_Register";
    private static final String COLUMN_STATUS="Status";
    private static final String COLUMN_TERM="Term";
    private static final String COLUMN_MAX_STUDENT="MaxStudent";
    
    private static final String ADD_SIGN_CLASS_DETAIL="INSERT INTO "+TABLE_SIGN_CLASS_DETAIL+"("+COLUMN_CLASS_ID+","+COLUMN_STUDENT_ID+","+COLUMN_TERM+","+COLUMN_STATUS+","+COLUMN_TIME_REGISTER+") "
            + " VALUES (?,?,?,?,?);";
    private static final String DELETE_SIGN_CLASS_DETAIL="DELETE FROM "+TABLE_SIGN_CLASS_DETAIL+" WHERE "+COLUMN_CLASS_ID+"=? AND "+COLUMN_STUDENT_ID+"=?;";
    private static final String GET_LIST_SIGN_CLASSROOM_BY_STUDENT_ID="SELECT * FROM "+TABLE_SIGN_CLASS_DETAIL+" WHERE "+COLUMN_STUDENT_ID+"=? AND "+COLUMN_TERM+"=?;";
    private static final String CHECK_MAX_SIGN_CLASS="SELECT * FROM "+TABLE_SIGN_CLASS_DETAIL+" WHERE "+COLUMN_CLASS_ID+"=?";
    private static final String GET_MAX_STUDENT_OF_CLASS="SELECT "+COLUMN_MAX_STUDENT+" FROM "+TABLE_CLASSROOM+" WHERE "+COLUMN_CLASS_ID+"=?";
    public static SqlSignClassDetailDao getInstance(){
        if(instance==null)
            instance= new SqlSignClassDetailDao();
        return instance;
    }
    @Override
    public int addSignClassDetail(SignClassDetail signClassDetail) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(ADD_SIGN_CLASS_DETAIL);
            pst.setString(1,signClassDetail.getClassID());
            pst.setString(2,signClassDetail.getStudentID());
            pst.setString(3,signClassDetail.getTerm());
            pst.setString(4,"ĐKTC");
            pst.setDate(5,new java.sql.Date(signClassDetail.getTimeSign().getTime()));
            pst.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
    }

    @Override
    public int deleteSignClassDetail(SignClassDetail signClassDetail) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(DELETE_SIGN_CLASS_DETAIL);
            pst.setString(1,signClassDetail.getClassID());
            pst.setString(2,signClassDetail.getStudentID());            
            pst.executeUpdate();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
    }

    @Override
    public List<SignClassDetail> getListSignClassRoomByStudentIdInTerm(String StudentID,String Term) {       
        List<SignClassDetail> listSignClassRoom= new ArrayList<>();
        try {
            Connection c = MySql.getInstance().getConnection();
            PreparedStatement pst= c.prepareStatement(GET_LIST_SIGN_CLASSROOM_BY_STUDENT_ID);
            pst.setString(1,StudentID);         
            pst.setString(2, Term);
            ResultSet rs= pst.executeQuery();
            while(rs.next()){
                SignClassDetail sCD= new SignClassDetail();
                sCD.setClassID(rs.getString(COLUMN_CLASS_ID));
                sCD.setStudentID(StudentID);
                sCD.setTerm(Term);
                sCD.setSignStatus(rs.getString(COLUMN_STATUS));
                sCD.setTimeSign(rs.getDate(COLUMN_TIME_REGISTER));
                listSignClassRoom.add(sCD);
            }
            return listSignClassRoom;
        } catch (SQLException ex) {
            Logger.getLogger(SqlSignClassDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }

    @Override
    public boolean checkMaxSignClass(String ClassroomId) {
        try {
            Connection c= MySql.getInstance().getConnection();
            PreparedStatement pst1= c.prepareStatement(CHECK_MAX_SIGN_CLASS);
            PreparedStatement pst2= c.prepareStatement(GET_MAX_STUDENT_OF_CLASS);
            pst1.setString(1, ClassroomId);
            ResultSet rs1= pst1.executeQuery();
            int count=0, maxStudent=0;
            while(rs1.next()){
                count++;
            }
            pst2.setString(2, ClassroomId);
            ResultSet rs2= pst2.executeQuery();
            while(rs2.next()){
                maxStudent=rs2.getInt(CHECK_MAX_SIGN_CLASS);
            }
            if(count<maxStudent)
                return true;
            else return false;
        } catch (SQLException ex) {
            Logger.getLogger(SqlSignClassDetailDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
