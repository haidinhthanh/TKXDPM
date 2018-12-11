/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterClassroom.Control;

import Classroom.Model.Classroom;
import Course.Model.Course;
import PermissionRegis.Control.PermissionController;
import Register.RegisterClassroom.Model.SignClassDetail;
import Register.RegisterCourse.Model.SignCourseDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haidt
 */
public class SignClassController {
    public boolean checkSignClassCondition(){
        PermissionController permissionController= new PermissionController();
	Date date= new Date(); 
        return permissionController.checkTimeRegisClass(date);
    }
    public boolean checkTermSignClass(String term){
        PermissionController permissionController= new PermissionController();
        return permissionController.checkTermSignClass(term);
    }
    public List<SignCourseDetail> getSignSucessCourseList(String Term, String StudentID){
        return new SignCourseDetail().getSignSucessCourseList(Term, StudentID);
    }
    public int checkSignCondition(List<SignCourseDetail> listSignCourse,Classroom signClass,Course signCourse,int sumCredit){
        if((sumCredit+signCourse.getCredit())>24){
            return 2;
        }
        for(int i=0;i<listSignCourse.size();i++){
            System.out.println(listSignCourse.get(i).getCourseID()+"=="+signClass.getCourseId());
            if(listSignCourse.get(i).getCourseID().equals(signClass.getCourseId())){
                return 1;
            }
        }
        return 0;
    }
    public int sendRequestSignClass(List<SignClassDetail> listAddSignClass,List<SignClassDetail> listDeleteSignClass){
        SignClassDetail signClassDetail= new SignClassDetail();
        int addFeedBack=0,deleteFeedBack=0;
        for (SignClassDetail sDC : listAddSignClass) {
            addFeedBack+=signClassDetail.addSignClassDetail(sDC);
        }
        for (SignClassDetail sDC : listDeleteSignClass){
            deleteFeedBack+=signClassDetail.deleteSignClassDetail(sDC);
        }
        return addFeedBack+deleteFeedBack;
    }
    public List<SignClassDetail> getListSignClassRoomByStudentIdInTerm(String StudentID,String Term){
        return new SignClassDetail().getListSignClassRoomByStudentIdInTerm(StudentID, Term);
    }
    public boolean checkMaxSignClass(String classId){
        return new SignClassDetail().checkMaxSignClass(classId);
    }
}
