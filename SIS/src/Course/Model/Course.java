/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Model;

import Course.Dao.SqlCourseDao;
import java.util.List;

/**
 *
 * @author haidt
 */
public class Course {
    private String CourseID;
    private String CourseName;
    private int Credit;
    private String CourseType;
    private String CourseCondition;
    private String ProgramId;
    public Course(){
        
    }
    public Course(String courseId,String coursName,int credit,String courseType, String courseCondition,String programId){
        this.CourseID=courseId;
        this.CourseName=coursName;
        this.Credit=credit;
        this.CourseType=courseType;
        this.CourseCondition=courseCondition;
        this.ProgramId=programId;
    }
            
    public String getCourseCondition() {
        return CourseCondition;
    }

    public String getCourseID() {
        return CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseType() {
        return CourseType;
    }

    public int getCredit() {
        return Credit;
    }

    public String getProgramId() {
        return ProgramId;
    }

    public void setCourseCondition(String CourseCondition) {
        this.CourseCondition = CourseCondition;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setCourseType(String CourseType) {
        this.CourseType = CourseType;
    }

    public void setCredit(int Credit) {
        this.Credit = Credit;
    }

    public void setProgramId(String ProgramId) {
        this.ProgramId = ProgramId;
    }
    public Course getCourseById(String CourseId){
        return SqlCourseDao.getInstance().getCourseById(CourseId);
    }
    public List<Course> getListCourseByListCourseId(String[] listId){
        return SqlCourseDao.getInstance().getListCourseByListCourseId(listId);
    }
    public List<Course> getAllCourse(){
        return SqlCourseDao.getInstance().getAllCourse();
    }
    public List<Course> searchCourseByCourseNameOrCourseId(String CourseID,String CourseName,int Credit){
        return SqlCourseDao.getInstance().findCourse(CourseID, CourseName, Credit);
    }
    public int checkExistCourseId(String courseId){
        return SqlCourseDao.getInstance().checkExistCourseId(courseId);
    }
    public int addNewCourse(Course course){
        return SqlCourseDao.getInstance().AddNewCourse(course);
    }
    public Course getCourseByCourseName(String CourseName){
        return SqlCourseDao.getInstance().getCourseByCourseName(CourseName);
    }
}
