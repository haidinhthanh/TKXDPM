/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classroom.Model;

import Classroom.Dao.SqlClassroomDao;
import Student.Model.Student;
import java.util.List;

/**
 *
 * @author haidt
 */
public class Classroom {
    private String ClassId;
    private int MaxStudent;
    private List<Student> StudentList;
    private String Place;
    private String ClassType;
    private String CourseId;
    private String Time;
    private String CourseName;
    private String State;

    public int getMaxStudent() {
        return MaxStudent;
    }

    public void setMaxStudent(int MaxStudent) {
        this.MaxStudent = MaxStudent;
    }
    
    
    public String getClassId() {
        return ClassId;
    }

    public String getClassType() {
        return ClassType;
    }

    public String getCourseId() {
        return CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getPlace() {
        return Place;
    }

    public List<Student> getStudentList() {
        return StudentList;
    }

    public String getTime() {
        return Time;
    }

    public void setClassId(String ClassId) {
        this.ClassId = ClassId;
    }

    public void setClassType(String ClassType) {
        this.ClassType = ClassType;
    }

    public void setCourseId(String CourseId) {
        this.CourseId = CourseId;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public void setStudentList(List<Student> StudentList) {
        this.StudentList = StudentList;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    public Classroom getClassRoomById(String ClassRoomId){
        return SqlClassroomDao.getInstance().getClassroomById(ClassRoomId);
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }
    
}
