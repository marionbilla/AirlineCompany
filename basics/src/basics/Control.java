package basics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Control {
    /*
    public Airline readAirline() {
        Scanner scanner= new Scanner(System.in);
        String name;
        Airline airline;
        name=scanner.nextLine();
        airline = new Airline(name);
        return airline;
    }
    
            
    public Flight readFlight() {
        Scanner scanner = new Scanner(System.in);
        String Departure;
        String Airline_Name;
        String Code;
        String Via;
        Date Expected_Departure = null;
        String Expected_Departure_S;
        Date Scheduled_Departure = null;
        String Scheduled_Departure_S;
        String Remarks;
        Flight flight;
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        
        Departure = scanner.nextLine();
        Airline_Name = scanner.nextLine();
        Code = scanner.nextLine();
        Via = scanner.nextLine();
        
        Expected_Departure_S = scanner.nextLine();
        
        try{
            Expected_Departure = sdf.parse(Expected_Departure_S);
        }
        catch(ParseException e) {
            System.out.println("Error. Details: " + e);
        }
        
        
        Scheduled_Departure_S = scanner.nextLine();
        
        try{
            Scheduled_Departure = sdf.parse(Scheduled_Departure_S);
        }
        catch(ParseException e) {
            System.out.println("Error. Details: " + e);
        }
        
        Remarks = scanner.nextLine();
        
        flight = new Flight(Departure, Airline_Name, Code, Via, Expected_Departure, Scheduled_Departure, Remarks);
        return flight;
    }
    
    public Airline readFromFile() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        Date date1;
        Date date2;
        Airline airline = new Airline("Null");
        Flight flight;
        String line;
        String[] temp = null;
        
        try {
            BufferedReader file = new BufferedReader(new FileReader("path"));
            while((line = file.readLine())!= null) {
                temp=line.split(",");
                date1 = new Date();
                try {
                    date1 = sdf.parse(temp[4]);
                } 
                catch (ParseException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                date2 = new Date();
                try {
                    date2 = sdf.parse(temp[5]);
                } 
                catch (ParseException ex) {
                    Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
                }

                flight =  new Flight(temp[0], temp[1], temp[2], temp[3], date1, date2, temp[6]);
                airline.getFlights().add(flight);
            }
            
            airline.setName(temp[1]);
        } 
        catch (IOException ex) {
            System.out.println(ex);
            System.exit(1);
        }
        
        
        return airline;
    }
    */
}
