package connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Connectiondb {
    
    private static Connection db;
    public static Connection getdb() {
        if (db==null) {  
            
          try {
           String url = new String();
           String user = new String();
           String password = new String();
           url = "jdbc:mysql://localhost:3306/mydb";
           user = "root";
           password = "cooDoodoo5$ub";
           
           DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
           db = DriverManager.getConnection(url,user,password);
           JOptionPane.showMessageDialog(null,"Connection Successful");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Connection Failed" +e);
                }       
        }
        return db;
    }
}
