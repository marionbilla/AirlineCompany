/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.DbTest;
import java.util.ArrayList;

/**
 *
 * @author it21233
 */
public class DemoGUI {
    
    public static ArrayList<basics.Flight> table = new ArrayList<>();
    public static ArrayList<basics.Airline> tableAir = new ArrayList<>();
    
    public static void main(String args[]) {
        fetchFlightsTable();
        mainBox.main(args);
    }
    
    private static void fetchFlightsTable() {
        database.DatabaseConnector dbcon = new database.DatabaseConnector();
        dbcon.initFlightsTable();
    }
}
