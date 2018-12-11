/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Control;

import Course.Model.Course;
import Course.Model.Program;
import ValidateInput.ValidateInput;
import com.sun.xml.internal.ws.util.StringUtils;
import java.util.List;

/**
 *
 * @author haidt
 */
public class CourseController {
   public Course getCourseById(String CourseId){
        return new Course().getCourseById(CourseId);
    } 
   public List<Course> getListCourseByListCourseId(String[] listId){
       return new Course().getListCourseByListCourseId(listId);
   }
   public List<Course> getAllCourse(){
       return new Course().getAllCourse();
   }
   public List<Program> getAllProgram(){
       return new Program().getAllProgram();
   }
   public List<Course> searchCourseByCourseNameOrCourseId(String courseId,String courseName){
       if(!courseId.isEmpty()&&!courseName.isEmpty())
           return new Course().searchCourseByCourseNameOrCourseId(courseId, courseName,3);
       else if(!courseId.isEmpty())
           return new Course().searchCourseByCourseNameOrCourseId(courseId, courseName,1);
       else if(!courseName.isEmpty())
           return new Course().searchCourseByCourseNameOrCourseId(courseId, courseName,2);
       return null;
   }
   public int checkCourseValid(Course course){
       //check CourseID
       if(!(course.getCourseID().substring(0, 2).equals(course.getProgramId())||ValidateInput.checkNumber(course.getCourseID().substring(3,course.getCourseID().length()-1))||course.getCourseID().length()==6)){
          return 1;
       }
       //check CourseName
       if(!(course.getCourseName().isEmpty()||course.getCourseName()==null)){
          return 2;
       }
       //check courseCredit
       if(course.getCredit()<=0)
           return 3;
       return new Course().checkExistCourseId(course.getCourseID());
   }
   public int addNewCourse(Course course){
       return new Course().addNewCourse(course);
   }
   public Course getCourseByCourseName(String courseName){
       return new Course().getCourseByCourseName(courseName);
   }
}
