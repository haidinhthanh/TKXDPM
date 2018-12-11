/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterCourse.Model;

import Course.Model.Course;
import Register.RegisterCourse.Dao.SqlSignCourseDetailDao;
import java.util.Date;
import java.util.List;

/**
 * This class is entity class of object SignCourseDetail
 * @author haidt
 */
public class SignCourseDetail {
    private String CourseID;
    private String CourseName;
    private long StudentID;
    private Date TimeSign;
    private String SignStatus;
    private String Term;

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }
    
    public String getCourseID() {
        return CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public long getStudentID() {
        return StudentID;
    }

    public Date getTimeSign() {
        return TimeSign;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setSignStatus(String SignStatus) {
        this.SignStatus = SignStatus;
    }

    public String getSignStatus() {
        return SignStatus;
    }
    
    public void setStudentID(long StudentID) {
        this.StudentID = StudentID;
    }

    public void setTimeSign(Date TimeSign) {
        this.TimeSign = TimeSign;
    }
    /**
     * This method call SqlSignCourseDetailDao instance add sign course in DB server 
     * @author haidt
     * @param signCourse course are sign to add
     * @param StudentID student id determined student
     * @param Term term sign course
     * @return 0 if add success and 1 if add failed
     */
    public int addSignCourseDetail(Course signCourse,String StudentID,String Term){
        return SqlSignCourseDetailDao.getInstance().addSignCourseDetail(signCourse, StudentID,Term);
    }
    /**
     * This method call SqlSignCourseDetailDao instance delete sign course in DB server 
     * @author haidt
     * @param signCourse course are sign to add
     * @param StudentID student id determined student
     * @return 0 if delete success and 1 if delete failed
     */
    public int deleteSignCourseDetail(Course signCourse,String StudentID){
        return SqlSignCourseDetailDao.getInstance().deleteSignCourseDetail(signCourse, StudentID);
    }
    /**
     * This method call SqlSignCourseDetailDao instance get all course sign in a term by a student in DB server 
     * @author haidt
     * @param StudentID student id determined student
     * @param Term term sign course
     * @return list course sign in a term by a student
     */
    public List<Course> getAllSignCourseDetailByStudentID(String StudentID,String Term){
        return SqlSignCourseDetailDao.getInstance().getAllSignCourseDetailByStudentID(StudentID, Term);
    }
    /**
     * This method call SqlSignCourseDetailDao instance get all sign course detail in a term by a student in DB server 
     * @author haidt 
     * @param Term term sign course
     * @param StudentID student id determined student
     * @return list sign course detail in a term by a student
     */
    public List<SignCourseDetail> getSignSucessCourseList(String Term,String StudentID){
        return SqlSignCourseDetailDao.getInstance().getSignSucessCourseList(Term, StudentID);
    }
}
