package org.railworldAirline.section;

import org.railworldAirline.App;
import org.railworldAirline.DAO.FlightDaoImpl;
import org.railworldAirline.model.Admin;
import org.railworldAirline.model.Flight;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//import static org.railworldAirline.App.adminMenu;

public class AdminSection {

    private FlightDaoImpl flightDaoImpl;

    AdminSection adminSection;
    public AdminSection()
    {
        this.flightDaoImpl = new FlightDaoImpl();
    }


    public boolean authenticateAdmin()
    {


        Scanner st = new Scanner(System.in);

        System.out.println("Enter Admin UserName : ");
        String username = st.nextLine();

        System.out.println("Enter Admin Password : ");
        String password = st.nextLine();

        return  flightDaoImpl.authenticateAdmin(username,password);

    }
    public void adminLogin()
    {

        System.out.println("Enter the Admin Username :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();


        System.out.println("Enter the Admin Password :");
        Scanner sc1 = new Scanner(System.in);
        String password = sc.nextLine();

        System.out.println("Enter the Admin First Name :");
        Scanner sc2 = new Scanner(System.in);
        String first = sc2.nextLine();

        System.out.println("Enter the Admin Last Name :");
        Scanner sc3 = new Scanner(System.in);
        String last = sc2.nextLine();

        Admin a = new Admin();
        a.setUserName(name);
        a.setPassword(password);
        a.setFirstname(first);
        a.setLastname(last);

        flightDaoImpl.adminLogin(a);

        System.out.println("========     Admin Register TO Us Successfully    ===========");

       // adminMenu(admin);
    }

    public void getFlightByFlightNumber() {

        System.out.println("Enter the Flight Number to get details:");
        Scanner sc = new Scanner(System.in);
        long flightNo = sc.nextLong();

        Flight flight = flightDaoImpl.getFlightByFlightNumber(flightNo);

        if (flight != null) {
            System.out.println("Flight Information:");
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Price: " + flight.getPrice());
            System.out.println("From: " + flight.getFrom());
            System.out.println("To: " + flight.getTo());
            System.out.println("Departure Time: " + flight.getDepartureTime());
            System.out.println("Arrival Time: " + flight.getArrivalTime());
            System.out.println("Date: " + flight.getDate());
        } else {
            System.out.println("Flight with ID " + flightNo + " not found.");
        }

    }

    public void getAllFlights() {

        List<Flight> flights = flightDaoImpl.getAllFlights();
        if (flights.isEmpty()) {
            System.out.println("No flights found.");
        } else {
            System.out.println("Flight Information:");
            for (Flight flight : flights) {
                System.out.println("Flight Number: " + flight.getFlightNumber());
                System.out.println("Price: " + flight.getPrice());
                System.out.println("From: " + flight.getDepartureTime());
                System.out.println("To: " + flight.getArrivalTime());
                System.out.println("Departure Time: " + flight.getDepartureTime());
                System.out.println("Arrival Time: " + flight.getArrivalTime());
                System.out.println("Date: " + flight.getDate());
                System.out.println();
            }
        }
    }
    public void addFlight()
    {

        System.out.println("Enter the Flight Number :");
        Scanner sc = new Scanner(System.in);
        long flightNo = sc.nextLong();


        System.out.println("Enter the Flight price :");
        Scanner sc1 = new Scanner(System.in);
        int flightprice = sc1.nextInt();

        System.out.println("Enter the Flight Source From :");
        Scanner sc2 = new Scanner(System.in);
        String flightFrom = sc2.nextLine();

        System.out.println("Enter the Flight Destination TO :");
        Scanner sc3 = new Scanner(System.in);
        String flightTo = sc2.nextLine();

        System.out.println("Enter the Flight Departure Time :");
        Scanner sc4 = new Scanner(System.in);
        String departure = sc4.nextLine();

        System.out.println("Enter the Flight Arrival Time :");
        Scanner sc5 = new Scanner(System.in);
        String arrival = sc5.nextLine();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date in format (dd-MM-yyyy): ");
        String dateString = scanner.nextLine();

        Flight flight = new Flight();
        flight.setFlightNumber(flightNo);
        flight.setPrice(flightprice);
        flight.setFrom(flightFrom);
        flight.setTo(flightTo);
        flight.setDepartureTime(departure);
        flight.setArrivalTime(arrival);
        flight.setDate(dateString);

        flightDaoImpl.addFlight(flight);

        System.out.println("Flight Details Added Successfully");
    }

    public void updateFlight()
    {

        System.out.println("Enter the Flight Number :");
        Scanner sc = new Scanner(System.in);
        long flightNo = sc.nextLong();


        Flight existingFlight = flightDaoImpl.getFlightByFlightNumber(flightNo);
        if (existingFlight == null) {
            System.out.println("Flight with number " + flightNo + " does not exist.");
            return;
        }


        System.out.println("Enter the Flight price :");
        Scanner sc1 = new Scanner(System.in);
        int flightprice = sc1.nextInt();

        System.out.println("Enter the Flight Source From :");
        Scanner sc2 = new Scanner(System.in);
        String flightFrom = sc2.nextLine();

        System.out.println("Enter the Flight Destination TO :");
        Scanner sc3 = new Scanner(System.in);
        String flightTo = sc3.nextLine();

        System.out.println("Enter the Flight Departure Time :");
        Scanner sc4 = new Scanner(System.in);
        String departure = sc4.nextLine();

        System.out.println("Enter the Flight Arrival Time :");
        Scanner sc5 = new Scanner(System.in);
        String arrival = sc5.nextLine();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date in format (dd-MM-yyyy): ");
        String dateString = scanner.nextLine();

        Flight flight = new Flight();
        existingFlight.setFlightNumber(flightNo);
        existingFlight.setPrice(flightprice);
        existingFlight.setFrom(flightFrom);
        existingFlight.setTo(flightTo);
        existingFlight.setDepartureTime(departure);
        existingFlight.setArrivalTime(arrival);
        existingFlight.setDate(dateString);

        flightDaoImpl.updateFlight(existingFlight);

        System.out.println("Flight Details Updated Successfully");
    }

    public void deleteFlight()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Flight ID to Delete Flight Information ");
        long id = scanner.nextLong();

       // Flight f2 = new Flight();
       // f2.setFlightNumber(id);

        flightDaoImpl.deleteFlight(id);

        System.out.println("Flight Details Deleted  Successfully");
    }
}
