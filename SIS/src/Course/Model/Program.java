/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Model;

import Course.Dao.SqlProgramDao;
import java.util.List;

/**
 *
 * @author haidt
 */
public class Program {
    private String ProgramId;
    private String ProgramName;

    public String getProgramId() {
        return ProgramId;
    }

    public String getProgramName() {
        return ProgramName;
    }

    public void setProgramId(String ProgramId) {
        this.ProgramId = ProgramId;
    }

    public void setProgramName(String ProgramName) {
        this.ProgramName = ProgramName;
    }
    public List<Program> getAllProgram(){
        return SqlProgramDao.getInstance().getAllProgram();
    }
    
}
