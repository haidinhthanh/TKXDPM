/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PermissionRegis.Control;

import PermissionRegis.Model.PermisionRegis;
import java.util.Date;

/**
 *
 * @author haidt
 */
public class PermissionController {
    public boolean checkTimeRegisCourse(Date date){
        return new PermisionRegis().getPermissionRegisCourse(date);
    }
    public boolean checkTimeRegisClass(Date date){
        return new PermisionRegis().getPermissionRegisClass(date);
    }
    public boolean checkTermSignCourse(String term){
         return new PermisionRegis().getPermissionRegisCourse(term);
    }
    public boolean checkTermSignClass(String term){
        return new PermisionRegis().getPermissionRegisClass(term);
    }
}
