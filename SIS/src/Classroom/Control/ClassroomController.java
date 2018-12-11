/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classroom.Control;

import Classroom.Model.Classroom;

/**
 *
 * @author haidt
 */
public class ClassroomController {
    public Classroom getClassroomById(String ClassRoomId){
        return new Classroom().getClassRoomById(ClassRoomId);
    }
}
