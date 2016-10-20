/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herc
 */
public class DatabaseConnector {
    private Connection conn;

    public DatabaseConnector(){
        conn=null;
        try {
            //load database driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger("Driver not found");
        }
        try {
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.100.51.123:1521:orcl", "it21233",
                    "salvinttls94");
        } catch (SQLException ex) {
            Logger.getLogger("Server not found");
        }
        
        if(conn != null){
            System.out.println("ok");
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void storeObject(basics.Airline airline){
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("INSERT INTO it21233.Airline VALUES ('"+airline.getName()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int storeObject(basics.Flight flight){
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //if(flight.getScheduled_Departure() != null) {
                Timestamp sqlExpected_Departure;
                Timestamp sqlScheduled_Departure = new java.sql.Timestamp(flight.getScheduled_Departure().getTime());
                if(flight.getExpected_Departure()!=null){
                    sqlExpected_Departure = new java.sql.Timestamp(flight.getExpected_Departure().getTime());
                }
                else {
                    sqlExpected_Departure = null;
                }
                String insertTableSQL = "INSERT INTO it21233.Flight "
                        + "VALUES (?,?,?,?,?,?,?)";
                PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
                preparedStatement.setString(1, flight.getDeparture());
                preparedStatement.setString(2,flight.getAirline_Name());
                preparedStatement.setString(3,flight.getCode());
                preparedStatement.setString(4,flight.getVia());
                preparedStatement.setTimestamp(5, sqlExpected_Departure);
                preparedStatement.setTimestamp(6, sqlScheduled_Departure);
                preparedStatement.setString(7, flight.getRemarks());
                
                ResultSet result = preparedStatement.executeQuery();
                
                
                //ResultSet rs=stmt.executeQuery("INSERT INTO it21233.Flight VALUES ('"+ flight.getDeparture() +"','"+ flight.getAirline_Name() +"','"+flight.getCode()+"','"+flight.getVia()+"',TO_DATE("+sqlExpected_Departure+", 'DD/MM/YYYY HH:MI'),TO_DATE("+sqlScheduled_Departure+", 'DD/MM/YYYY HH:MI'),'"+flight.getRemarks()+"')");
            //}
            //else {
            //    ResultSet rs=stmt.executeQuery("INSERT INTO it21233.Flight VALUES ()");
            //}
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
        return 0;
    }
    
    public void updateObject(basics.Airline airline){
        
    }
    
    public void updateObject(basics.Flight flight){
        
    }
    
    public void deleteObject(basics.Flight flight){
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("DELETE FROM it21233.Flight WHERE Code='"+flight.getCode()+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteObject(String airline_name) {
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("DELETE FROM it21233.Flight WHERE Airline_name='"+airline_name+"'");
            rs = stmt.executeQuery("DELETE FROM it21233.Airline WHERE Name='"+airline_name+"'");
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initFlightsTable(){
        Statement stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("SELECT * FROM it21233.Flight");
            int i =0;
            basics.Flight flight = null;
            while(rs.next()) {
                flight = new basics.Flight(rs.getString("Departure"),rs.getString("Airline_name"),rs.getString("Code"),rs.getString("Via"),rs.getTimestamp("Expected_Departure"),rs.getTimestamp("Scheduled_Departure"),rs.getString("Remarks"));
                
                gui.DemoGUI.table.add(flight);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        int size;
        stmt=null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ResultSet rs=stmt.executeQuery("SELECT * FROM it21233.Airline");
            basics.Airline airline = null;
            System.out.println(rs.toString());
            while(rs.next()) {
                airline = new basics.Airline(rs.getString("Name"));
                gui.DemoGUI.tableAir.add(airline);
                size = gui.DemoGUI.tableAir.size();
                for(int i = 0; i < gui.DemoGUI.table.size();i++) {
                    if(gui.DemoGUI.tableAir.get(size-1).getName().equals(gui.DemoGUI.table.get(i).getAirline_Name())) {
                        gui.DemoGUI.tableAir.get(size-1).getFlights().add(gui.DemoGUI.table.get(i));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /*public ArrayList<basics.Airline> getAirlines(){
        return null;
    }*/

}