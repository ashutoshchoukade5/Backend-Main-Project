package org.railworldAirline.section;

import org.railworldAirline.DAO.UserDaoImpl;
import org.railworldAirline.model.BookTicket;

import java.util.Scanner;

public class TripSection {


    public UserDaoImpl userDaoImpl;

    public TripSection() {

        this.userDaoImpl= new UserDaoImpl();
    }

    public void singleTrip()
    {

        System.out.println("Enter the Flight Source :");
        Scanner sc = new Scanner(System.in);
        String flightFrom = sc.nextLine();


        System.out.println("Enter the Flight Destination :");
        Scanner sc1 = new Scanner(System.in);
        String flightTo = sc1.nextLine();


        System.out.println("Enter the Flight Date :");
        Scanner sc2 = new Scanner(System.in);
        String flightDate = sc2.nextLine();

        System.out.println("Enter the Flight Class :");
        Scanner sc3 = new Scanner(System.in);
        String flightClass = sc2.nextLine();

        System.out.println("Enter the No of Member :");
        Scanner sc4 = new Scanner(System.in);
        int member = sc2.nextInt();

        BookTicket bkt = new BookTicket(flightFrom,flightTo,flightDate,flightClass,member);

        userDaoImpl.bookTicket(bkt);

        System.out.println("Flight For Single Trip Booked Sucessfully");

        System.out.println("Here Is Your Ticket :\n");

        System.out.println("           Railworld Airline          ");
        System.out.println("===========================================");
        System.out.println("Source :"+flightFrom+"\t\t\t\t"+"Destination : "+flightTo);
        System.out.println("Date : "+flightDate+"\t\t\t\t"+"Class : "+flightClass);
        System.out.println("Member : "+member);
       // System.out.println("--------------------------------------");
        System.out.println("--------    Enjoy Yor Journey  --------\n");
        System.out.println("===========================================");
    }


    public void roundTrip()
    {

        System.out.println("Enter the Flight Source :");
        Scanner sc = new Scanner(System.in);
        String flightFrom = sc.nextLine();


        System.out.println("Enter the Flight Destination :");
        Scanner sc1 = new Scanner(System.in);
        String flightTo = sc1.nextLine();

        System.out.println("Enter the Flight Date :");
        Scanner sc2 = new Scanner(System.in);
        String flightDate = sc2.nextLine();

        System.out.println("Enter the Flight Class :");
        Scanner sc3 = new Scanner(System.in);
        String flightClass = sc2.nextLine();

        System.out.println("Enter the No of Member :");
        Scanner sc4 = new Scanner(System.in);
        int member = sc2.nextInt();

        System.out.println("Enter the Return Flight Date :");
        Scanner st = new Scanner(System.in);
        String fly = st.nextLine();


        BookTicket bk = new BookTicket(flightFrom,flightTo,flightDate,flightClass,fly,member);

        userDaoImpl.bookTicket(bk);

        System.out.println("Flight For Round Trip Booked Successfully");
    }
}
