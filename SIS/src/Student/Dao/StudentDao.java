/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.Dao;

import Student.Model.Student;

/**
 * This is interface for entity student access DB server
 * @author haidt
 */
public interface StudentDao{
    /**
     * This method get student information by student ID like "20151178"
     * @param StudentId student id determine student
     * @return object student
     */
    public Student getStudentByID(String StudentId);
}
