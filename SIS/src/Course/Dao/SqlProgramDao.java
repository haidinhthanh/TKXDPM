/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course.Dao;

import Course.Model.Program;
import Sql.MySql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haidt
 */
public class SqlProgramDao {
    private static SqlProgramDao instance;
    private static final String TABLE_PROGRAM="program";
    private static final String COLUMN_PROGRAM_ID="Program_ID";
    private static final String COLUMN_PROGRAM_NAME="Program_Name";
    
    private static final String GET_ALL_COURSE="SELECT * FROM "+TABLE_PROGRAM;
    public static SqlProgramDao getInstance(){
        if(instance==null)
            instance= new SqlProgramDao();
        return instance;
    }
    public List<Program> getAllProgram(){
        try {
            List<Program> listProgram= new ArrayList<>();
            Connection c= MySql.getInstance().getConnection();
            ResultSet rs= c.createStatement().executeQuery(GET_ALL_COURSE);
            while (rs.next()) {                
                Program program= new Program();
                program.setProgramId(rs.getString(COLUMN_PROGRAM_ID));
                program.setProgramName(rs.getString(COLUMN_PROGRAM_NAME));
                listProgram.add(program);
            }
            return listProgram;
        } catch (SQLException ex) {
            Logger.getLogger(SqlProgramDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
