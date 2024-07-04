package org.railworldAirline.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.railworldAirline.App;
import org.railworldAirline.Util.AirlineUtil;
import org.railworldAirline.model.Admin;
import org.railworldAirline.model.Flight;
import org.railworldAirline.section.AdminSection;

import java.util.List;

public class FlightDaoImpl  implements  FlightDao{

AdminSection adminSection;

    @Override
    public boolean authenticateAdmin(String userName, String password) {

                try (Session session = AirlineUtil.getSessionFactory().openSession()) {
                    Query<Admin> query = session.createQuery("FROM Admin WHERE userName = :username", Admin.class);
                    query.setParameter("username", userName);
                    Admin admin = query.uniqueResult();

                    if (admin != null && admin.getPassword().equals(password))
                    {

                        System.out.println("Login Successfully");

                        return true;
            }

            else
            {
                System.out.println("Login Failed");
                App.adminLoginMenu(adminSection);
                return false;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void adminLogin(Admin admin) {

        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }

    }


    @Override
    public Flight getFlightByFlightNumber(long flightNumber)
    {
        Session session = AirlineUtil.getSessionFactory().openSession();
        Flight flight = session.get(Flight.class, flightNumber);
        session.close();

        return flight;
    }

    @Override
    public List<Flight> getAllFlights() {

        Session session = AirlineUtil.getSessionFactory().openSession();
        try {
            Query<Flight> query = session.createQuery("FROM Flight", Flight.class);
            return query.list();
        } finally {
            session.close();
        }
    }



    @Override
    public void addFlight(Flight flight) {

        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public void updateFlight(Flight flight) {


        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(flight);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteFlight(long id) {

        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Flight flightToDelete = session.get(Flight.class, id); // Retrieve the Flight entity by its ID
            if (flightToDelete != null) {
                session.delete(flightToDelete); // Delete the retrieved Flight entity
            } else {
                System.out.println("Flight with ID " + id + " does not exist.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

}
