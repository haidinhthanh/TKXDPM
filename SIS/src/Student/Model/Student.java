/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student.Model;

import java.util.Date;

/**
 * This class is entity class of object Student
 * @author haidt
 */
public class Student {
    private String studentID;
    private String name;
    private Date birth;
    private String address;
    private String email;
    private String phone;
    private Date dateStart;
    private String programId;
    private String gender;

    public String getAddress() {
        return address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProgramId() {
        return programId;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
   
}
