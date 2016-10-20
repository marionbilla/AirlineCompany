package basics;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    public static void main() {
        /*
        ArrayList<Airline> Airlines = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        FlightsTable flightstable=new FlightsTable();
        Airlines.add(new Airline("Aegean"));
        Airlines.add(new Airline("Swiss"));
        Airlines.add(new Airline("Olympic Air"));
        try {
            System.out.println(sdf.parse("21/12/2012 00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:01"), "ON_TIME"));
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:02"), "ON_TIME"));
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:03"), "ON_TIME"));
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:04"), "ON_TIME"));
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:05"), "ON_TIME"));
            Airlines.get(0).getFlights().add(new Flight("Departure", "Airline1", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:06"), "ON_TIME"));

            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:07"), "ON_TIME"));
            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:08"), "ON_TIME"));
            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:09"), "ON_TIME"));
            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:10"), "ON_TIME"));
            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:11"), "ON_TIME"));
            Airlines.get(1).getFlights().add(new Flight("Departure", "Airline2", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:12"), "ON_TIME"));

            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:13"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:14"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:15"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:16"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:17"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:18"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:19"), "ON_TIME"));
            Airlines.get(2).getFlights().add(new Flight("Departure", "Airline3", "code", "via", sdf.parse("21/12/2012 00:00"), sdf.parse("21/12/2012 00:20"), "ON_TIME"));
        }
        catch (ParseException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<Airlines.size();i++) {
            for(int j=0;j<Airlines.get(i).getFlights().size(); j++) {
                flightstable.getFlights().add(Airlines.get(i).getFlights().get(j));
            }
        }
       
        Collections.sort(flightstable.getFlights());
        
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");

        for(int j=0;j<4;j++)
        {
            if(j==0){
                flightstable.getFlights().get(0).setRemarks("Boarding");
                flightstable.getFlights().get(1).setRemarks("Delayed");
                flightstable.getFlights().get(2).setRemarks("Boarding");
            }
            if(j==1) {
                flightstable.getFlights().get(0).setRemarks("Departed");
                flightstable.getFlights().get(1).setRemarks("Boarding");
                flightstable.getFlights().get(2).setRemarks("Departed");
            }
            if(j==2){
                flightstable.getFlights().get(0).setRemarks("Departed");
                flightstable.getFlights().get(1).setRemarks("Departed");
                flightstable.getFlights().get(2).setRemarks("Departed");
            }
            
            for(int i=0;i<10;i++) {
                System.out.println(flightstable.getFlights().get(i).getDeparture() + ", "
                                     + flightstable.getFlights().get(i).getAirline_Name() + ", " 
                                     + flightstable.getFlights().get(i).getCode() + ", " 
                                     + flightstable.getFlights().get(i).getVia() + ", " 
                                     + df.format(flightstable.getFlights().get(i).getExpected_Departure()) + ", " 
                                     + df.format(flightstable.getFlights().get(i).getScheduled_Departure()) + ", " 
                                     + flightstable.getFlights().get(i).getRemarks());
            }
            
            System.out.println();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    */
    }
}
