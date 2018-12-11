/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterCourse.Dao;

import Course.Model.Course;
import Register.RegisterCourse.Model.SignCourseDetail;
import java.util.List;

/**
 *
 * @author haidt
 */
public interface SignCourseDetailDao {
    public int addSignCourseDetail(Course signCourse,String StudentID,String Term);
    public int deleteSignCourseDetail(Course signCourse,String StudentID);
    public List<Course> getAllSignCourseDetailByStudentID(String StudentID,String Term);
    public List<SignCourseDetail> getSignSucessCourseList(String Term,String StudentID);
}
