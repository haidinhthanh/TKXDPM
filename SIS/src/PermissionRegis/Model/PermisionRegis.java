/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionRegis.Model;

import PermissionRegis.Dao.SqlPermissionRegisDao;
import java.util.Date;

/**
 *
 * @author haidt
 */
public class PermisionRegis {
    private int Id;
    private String NamePermission;
    private Date DateStart;
    private Date DateEnd;

    public Date getDateEnd() {
        return DateEnd;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public String getNamePermission() {
        return NamePermission;
    }
    public int getId() {
        return Id;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public void setNamePermission(String NamePermission) {
        this.NamePermission = NamePermission;
    }
    public boolean  getPermissionRegisCourse(Date date){
        return SqlPermissionRegisDao.getInstance().getPermissionRegisCourse(date);
    }
    public boolean  getPermissionRegisCourse(String term){
        return SqlPermissionRegisDao.getInstance().getPermissionRegisCourse(term);
    }
    public boolean  getPermissionRegisClass(Date date){
        return SqlPermissionRegisDao.getInstance().getPermissionRegisClass(date);
    }
    public boolean getPermissionRegisClass(String term){
        return SqlPermissionRegisDao.getInstance().getPermissionRegisClass(term);
    }
}
