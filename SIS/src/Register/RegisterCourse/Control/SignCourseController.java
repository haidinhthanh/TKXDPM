/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterCourse.Control;

import Classroom.Model.Classroom;
import Course.Model.Course;
import CourseMark.Model.CourseMark;
import PermissionRegis.Control.PermissionController;
import Register.RegisterClassroom.Dao.SqlSignClassDetailDao;
import Register.RegisterClassroom.Model.SignClassDetail;
import Register.RegisterCourse.Model.SignCourseDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haidt
 */
public class SignCourseController {
    public boolean checkSignCourseCondition() {
        PermissionController permissionController= new PermissionController();
	Date date= new Date(); 
        return permissionController.checkTimeRegisCourse(date);
    }
    public boolean checkTermSignCourse(String term){
        PermissionController permissionController= new PermissionController();
        return permissionController.checkTermSignCourse(term);
    }
    public List<Course> getLearnedCourse(String StudentId){
        CourseMark courseMark= new CourseMark();
        return courseMark.getLearnedCourse(StudentId);
    }
    public int checkSignCondition(List<Course> listLearnedCourse, Course signCourse,int sumCredit){
        for(int i=0;i<listLearnedCourse.size();i++){
            if(listLearnedCourse.get(i).getCourseID().equals(signCourse.getCourseID()))
                return 2;
        }
        if(sumCredit+signCourse.getCredit()>24){
            return 3;
        }
        if(!(signCourse.getCourseCondition()==null)){
            String[] listCourseCondition=signCourse.getCourseCondition().split("-");                      
            if(listLearnedCourse.isEmpty())
                return 1;
            else{
                int numberConditionCheck=0;
                for (String listCourseCondition1 : listCourseCondition) {
                    for (int i = 0; i<listLearnedCourse.size(); i++) {
                        if (listCourseCondition1.equals(listLearnedCourse.get(i).getCourseID())) {
                            numberConditionCheck= numberConditionCheck+1;
                            break;
                        }
                    }
                    if(numberConditionCheck==listCourseCondition.length)
                        return 1;
                }
                return 0;
            }            
        }
        return 1;
    }
    public int sendRequestSignCourse(String Term,List<Course> listAddCourse,List<Course> listDeleteCourse,String StudentID){
        SignCourseDetail signCourseDetail= new SignCourseDetail();
        int addFeedBack=0,deleteFeedBack=0;
        for (Course lAC : listAddCourse) {
            addFeedBack+=signCourseDetail.addSignCourseDetail(lAC, StudentID,Term);
        }
        for (Course lDC : listDeleteCourse){
            deleteFeedBack+=signCourseDetail.deleteSignCourseDetail(lDC, StudentID);
        }
        return addFeedBack+deleteFeedBack;
    }
    public List<Course> getAllSignCourseDetailByStudentID(String StudentID,String Term){
        SignCourseDetail sCD= new SignCourseDetail();
        return sCD.getAllSignCourseDetailByStudentID(StudentID, Term);
    }
}
