package org.railworldAirline;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.railworldAirline.DAO.FlightDaoImpl;
import org.railworldAirline.DAO.UserDaoImpl;

import org.railworldAirline.section.AdminSection;
import org.railworldAirline.section.TripSection;
import org.railworldAirline.section.UserSection;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;

/**
 * Hello world!
 *
 */
public class App {

    Scanner scanner = new Scanner(System.in);

    AdminSection adminSection;
    UserSection userSection;

    TripSection tripSection;


    public App() {

        this.adminSection = new AdminSection();
        this.userSection = new UserSection();
        this.tripSection = new TripSection();

    }

    public void startProject()
    {

        while (true) {
            System.out.println("Welcome to Airline Reservation System");
            System.out.println("1. Admin Login or Signup");
            System.out.println("2. User Login or Signup");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Admin login logic Function
                    adminLoginMenu(adminSection);

                    break;

                case 2:
                    // User login logic

                    userLoginMenu(userSection);


                    break;

                case 3:
                    System.out.println("Exiting Airline Reservation System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public static void adminLoginMenu(AdminSection adminSection)
    {
        Scanner st = new Scanner(System.in);

        while(true)
        {

            System.out.println("Admin Authentication Menu:");
            System.out.println("1. Login ");
            System.out.println("2. Signup");
            System.out.println("3. Back");
            System.out.println("Enter Your Choice : ");

            int a = st.nextInt();
            st.nextLine();

            switch (a)
            {
                case 1 :

                    if(adminSection.authenticateAdmin()) {
                        adminMenu(adminSection);
                    }
                    else
                    {
                        System.out.println("Authentication failed. Please try again.");
                    }
                    break;



                case 2 :
                    adminSection.adminLogin();
                    break;

                case 3 :
                    return ;
            }
        }
    }

    private static void adminMenu(AdminSection adminSection) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add New Flight");
            System.out.println("2. Update Flight Info");
            System.out.println("3. Cancel Flight");
            System.out.println("4. Get Flight Details By Flight Number");
            System.out.println("5. Get All Flight Details ");
            System.out.println("6. Logout From Admin Section ");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    adminSection.addFlight();
                    break;
                case 2:
                    adminSection.updateFlight();
                    break;
                case 3:
                    adminSection.deleteFlight();
                    break;
                case 4:
                    adminSection.getFlightByFlightNumber();
                    break;
                case 5:
                    adminSection.getAllFlights();
                    break;
                case 6:
                    System.out.println("Logged out from Admin account.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }






    public static  void userLoginMenu(UserSection userSection)
    {

        Scanner st = new Scanner(System.in);

        while(true)
        {

            System.out.println("User Authentication Menu:");
            System.out.println("1. Login ");
            System.out.println("2. Signup");
            System.out.println("3. Back");
            System.out.println("Enter Your Choice : ");

            int a = st.nextInt();
            st.nextLine();

            switch (a)
            {
                case 1 :
                    userSection.authenticateUser();

                    userMenu(userSection);
                    break;

                case 2 :
                    userSection.userLogin();
                    break;

                case 3 :
                    return ;
            }
        }

    }



    private static void userMenu(UserSection userSection) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Book Flight Ticket");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Logout");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userSection.bookTicket();
                    break;

                case 2:
                    userSection.cancelTicket();
                    break;

                case 3:
                    System.out.println("Logged out from User account.");
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }




        public static void bookTicketMenu(TripSection tripSection){
            Scanner scanner2 = new Scanner(System.in);
            while (true) {
                System.out.println("Book Ticket Menu:");
                System.out.println("1. Book Single Trip Ticket");
                System.out.println("2. Book Round Trip Ticket");
                System.out.println("3. Back to User Menu");
                System.out.println("Enter your choice: ");
                int choice = scanner2.nextInt();
                scanner2.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        tripSection.singleTrip();
                        break;

                    case 2:
                        tripSection.roundTrip();
                        break;

                    case 3:
                        return;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }



    public static void main(String[] args) {

        App a = new App();
        a.startProject();
    }

}
