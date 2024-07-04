package org.railworldAirline.section;

import org.railworldAirline.App;
import org.railworldAirline.DAO.UserDaoImpl;
import org.railworldAirline.model.Admin;
import org.railworldAirline.model.User;

import java.util.Scanner;

public class UserSection {


    public UserDaoImpl userDaoImpl;

    public TripSection tripSection;

    public UserSection() {
        this.userDaoImpl = new UserDaoImpl();
        this.tripSection = new TripSection();
    }


    public boolean authenticateUser()
    {
        Scanner st = new Scanner(System.in);

        System.out.println("Enter User UserName : ");
        String username = st.nextLine();

        System.out.println("Enter User Password : ");
        String password = st.nextLine();

       // System.out.println("===   User Login Successfully   ===");

        return  userDaoImpl.authenticateUser(username,password);
    }

    public void userLogin()
    {
        System.out.println("Enter the User Username :");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();


        System.out.println("Enter the User Password :");
        Scanner sc1 = new Scanner(System.in);
        String password = sc.nextLine();

        System.out.println("Enter the User  First Name :");
        Scanner sc2 = new Scanner(System.in);
        String first = sc2.nextLine();

        System.out.println("Enter the User Last Name :");
        Scanner sc3 = new Scanner(System.in);
        String last = sc2.nextLine();

        System.out.println("Enter the User Age :");
        Scanner sc4 = new Scanner(System.in);
        int age = sc2.nextInt();

        System.out.println("Enter the User Gender :");
        Scanner sc5 = new Scanner(System.in);
        String gender = sc5.nextLine();

        System.out.println("Enter the User Phone NO :");
        Scanner sc6 = new Scanner(System.in);
        String phone = sc2.nextLine();


        User a = new User();

        a.setUserName(name);
        a.setPassword(password);
        a.setFirstname(first);
        a.setLastname(last);
        a.setAge(age);
        a.setGender(gender);
        a.setPhone(phone);

        userDaoImpl.userLogin(a);

        System.out.println("========     User Register TO Us Successfully    ===========");
    }

    public void bookTicket()
    {

        TripSection t = new TripSection();
        App.bookTicketMenu(t);
    }

    public void cancelTicket()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Booking ID to Delete Book Flight ");
        long id = scanner.nextLong();

        // Flight f2 = new Flight();
        // f2.setFlightNumber(id);

        userDaoImpl.cancelTicket(id);

        System.out.println("Flight Details Deleted  Successfully");
    }

    }





