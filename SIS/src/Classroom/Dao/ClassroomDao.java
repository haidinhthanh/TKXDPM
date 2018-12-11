/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classroom.Dao;

import Classroom.Model.Classroom;

/**
 *
 * @author haidt
 */
public interface ClassroomDao {
    public Classroom getClassroomById(String ClassRoomId);
}
