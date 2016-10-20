package basics;

import java.util.ArrayList;

public class Airline {
    private String name;
    private ArrayList<Flight> Flights = new ArrayList<>();
    
    public Airline(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Flight> getFlights() {
        return Flights;
    }

    public void setFlights(ArrayList<Flight> Flights) {
        this.Flights = Flights;
    }
    
}
