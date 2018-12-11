/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseMark.Model;

import Course.Model.Course;
import CourseMark.Dao.SqlCourseMarkDao;
import java.util.List;

/**
 *
 * @author haidt
 */
public class CourseMark {
    private long StudentID;
    private String CourseID;
    private String CourseName;
    private String Term;
    private float MidMark;
    private float FinalMark;
    private float CourseMark;

    public String getCourseID() {
        return CourseID;
    }

    public float getCourseMark() {
        return CourseMark;
    }

    public String getCourseName() {
        return CourseName;
    }

    public float getFinalMark() {
        return FinalMark;
    }

    public float getMidMark() {
        return MidMark;
    }

    public long getStudentID() {
        return StudentID;
    }

    public String getTerm() {
        return Term;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public void setCourseMark(float CourseMark) {
        this.CourseMark = CourseMark;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setFinalMark(float FinalMark) {
        this.FinalMark = FinalMark;
    }

    public void setMidMark(float MidMark) {
        this.MidMark = MidMark;
    }

    public void setStudentID(long StudentID) {
        this.StudentID = StudentID;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }
    public List<Course> getLearnedCourse(String StudentID){
        return SqlCourseMarkDao.getInstance().getLearnedCourse(StudentID);
    }
}
