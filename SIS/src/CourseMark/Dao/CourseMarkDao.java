/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseMark.Dao;

import Course.Model.Course;
import java.util.List;

/**
 *
 * @author haidt
 */
public interface CourseMarkDao {
    public List<Course> getLearnedCourse(String StudentID);
}
