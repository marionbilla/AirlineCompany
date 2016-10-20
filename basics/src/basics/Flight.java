package basics;

import java.sql.Timestamp;
import java.util.Date;

public class Flight implements Comparable<Flight>{
    private String Departure;
    private String Airline_Name;
    private String Code;
    private String Via;
    private Timestamp Expected_Departure;
    private Timestamp Scheduled_Departure;
    private String Remarks;
    
    public Flight(String Departure, String Airline_Name, String Code, String Via, Timestamp Expected_Departure, Timestamp Scheduled_Departure, String Remarks) {
        this.Departure = Departure;
        this.Airline_Name = Airline_Name;
        this.Code = Code;
        this.Via = Via;
        this.Expected_Departure = Expected_Departure;
        this.Scheduled_Departure = Scheduled_Departure;
        this.Remarks = Remarks;
    }
    
    @Override
    public int compareTo(Flight flight) {
        return getScheduled_Departure().compareTo(flight.getScheduled_Departure());
    }
    
    public String getDeparture() {
        return Departure;
    }

    public void setDeparture(String Departure) {
        this.Departure = Departure;
    }

    public String getAirline_Name() {
        return Airline_Name;
    }

    public void setAirline_Name(String Airline_Name) {
        this.Airline_Name = Airline_Name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getVia() {
        return Via;
    }

    public void setVia(String Via) {
        this.Via = Via;
    }

    public Date getExpected_Departure() {
        return Expected_Departure;
    }

    public void setExpected_Departure(Timestamp Expected_Departure) {
        this.Expected_Departure = Expected_Departure;
    }

    public Date getScheduled_Departure() {
        return Scheduled_Departure;
    }

    public void setScheduled_Departure(Timestamp Scheduled_Departure) {
        this.Scheduled_Departure = Scheduled_Departure;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }
}
