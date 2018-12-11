/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionRegis.Dao;

import java.util.Date;

/**
 *
 * @author haidt
 */
public interface PermissionRegisDao {
    public boolean getPermissionRegisCourse(Date date);
    public boolean getPermissionRegisCourse(String term);
    public boolean getPermissionRegisClass(Date date);
    public boolean getPermissionRegisClass(String term);
}
