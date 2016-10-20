/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herc
 */
public class DbTest {

    public static void main(String args[]){
        Connection connection=null;
        Statement stmt=null;
        try {
            //load database driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("Driver not found");
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.100.51.123:1521:orcl", "it21233",
                    "salvinttls94");
        } catch (SQLException ex) {
            Logger.getLogger("Server not found");
        }
        System.out.println("ok");
        try {
            stmt = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("select fname,lname,salary from employee");
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+":"+rs.getDouble(3));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
