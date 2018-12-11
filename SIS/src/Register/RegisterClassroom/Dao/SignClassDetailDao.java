/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.RegisterClassroom.Dao;

import Classroom.Model.Classroom;
import Register.RegisterClassroom.Model.SignClassDetail;
import java.util.List;

/**
 *
 * @author haidt
 */
public interface SignClassDetailDao {
    public int addSignClassDetail(SignClassDetail signClassDetail);
    public int deleteSignClassDetail(SignClassDetail signClassDetail);
    public List<SignClassDetail> getListSignClassRoomByStudentIdInTerm(String StudentID,String Term);
    public boolean checkMaxSignClass(String ClassroomId);
}
