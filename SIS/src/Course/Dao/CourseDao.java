/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Dao;

import Course.Model.Course;
import java.util.List;

/**
 *
 * @author haidt
 */
public interface CourseDao {
    public Course getCourseById(String CourseId);
    public Course getCourseByCourseName(String CourseName);
    public List<Course> getListCourseByListCourseId(String[] listId);
    public List<Course> findCourse(String courseId,String courseName,int typeSearch);
    public int checkExistCourseId(String courseId);
    public int AddNewCourse(Course course);
    public List<Course> getAllCourse();
}
