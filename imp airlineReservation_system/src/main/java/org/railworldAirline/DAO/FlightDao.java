package org.railworldAirline.DAO;

import org.railworldAirline.model.Admin;
import org.railworldAirline.model.Flight;

import java.util.List;

public interface FlightDao {

    public void adminLogin(Admin admin);

    public boolean authenticateAdmin(String userName , String password);

    public void addFlight(Flight flight);

    public void updateFlight(Flight flight);

    public void deleteFlight(long id);

    public Flight getFlightByFlightNumber(long flightNumber) ;

    public List<Flight> getAllFlights();
}
