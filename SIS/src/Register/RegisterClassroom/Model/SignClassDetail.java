/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterClassroom.Model;

import Classroom.Model.Classroom;
import Register.RegisterClassroom.Dao.SqlSignClassDetailDao;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haidt
 */
public class SignClassDetail {
    private String StudentID;
    private String ClassID;
    private Date TimeSign;
    private String SignStatus;
    private String Term;

    public String getClassID() {
        return ClassID;
    }

    public String getSignStatus() {
        return SignStatus;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getTerm() {
        return Term;
    }

    public Date getTimeSign() {
        return TimeSign;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public void setSignStatus(String SignStatus) {
        this.SignStatus = SignStatus;
    }

    public void setStudentID(String StudentID) {
        this.StudentID = StudentID;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

    public void setTimeSign(Date TimeSign) {
        this.TimeSign = TimeSign;
    }
    public int addSignClassDetail(SignClassDetail signClassDetail){
        return SqlSignClassDetailDao.getInstance().addSignClassDetail(signClassDetail);
    }
    public int deleteSignClassDetail(SignClassDetail signClassDetail){
        return SqlSignClassDetailDao.getInstance().deleteSignClassDetail(signClassDetail);
    }
    public List<SignClassDetail> getListSignClassRoomByStudentIdInTerm(String StudentID,String Term){
        return SqlSignClassDetailDao.getInstance().getListSignClassRoomByStudentIdInTerm(StudentID, Term);
    }
    public boolean checkMaxSignClass(String classId){
        return SqlSignClassDetailDao.getInstance().checkMaxSignClass(classId);
    }
}
