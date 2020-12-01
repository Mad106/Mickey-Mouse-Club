/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionmysql;

/**
 *
 * @author Ashen Eyes
 */
import connectiondb.Connectiondb;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class Show {
    public static void main(String[] args)
    {
        String query = "SELECT * FROM show";
        Connection db = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            db = Connectiondb.getdb();
            stmt = db.prepareStatement(query);
            
            rs = stmt.executeQuery(query);
           
            while(rs.next()){
             String showName = rs.getString("show_name");
             System.out.println(showName);
              }
        }
        catch(SQLException ex){
                Logger.getLogger(Show.class.getName()).log(Level.SEVERE, null, ex);
                }
        finally
        {
            if (rs != null) {
        try {
            rs.close();
        } catch (SQLException e) {}
        
            }
            if (stmt != null) {
        try {
            stmt.close();
        } catch (SQLException e) {}
        
            }
        if (db != null) {
        try {
            db.close();
        } catch (SQLException e) {}
            }
        }
        
    }
}