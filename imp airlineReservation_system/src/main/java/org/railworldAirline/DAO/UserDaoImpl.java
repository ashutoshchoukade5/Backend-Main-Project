package org.railworldAirline.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.railworldAirline.Util.AirlineUtil;
import org.railworldAirline.model.BookTicket;
import org.railworldAirline.model.Flight;
import org.railworldAirline.model.User;

public class UserDaoImpl implements UserDao{


    @Override
    public boolean authenticateUser(String userName, String password)
    {

        boolean authenticateUser = false;

        try (Session session = AirlineUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("FROM User WHERE userName = :username", User.class);
            query.setParameter("username", userName);
            User user = query.uniqueResult();

            if (user != null && user.getPassword().equals(password))
            {
                System.out.println("Login Successfully");
            }

            else
            {
                System.out.println("Login Failed");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void userLogin(User user) {
        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
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
    public void bookTicket(BookTicket bookTicket) {

        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(bookTicket);
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
    public void cancelTicket(long id) {

        Session session = AirlineUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            BookTicket flightToDelete = session.get(BookTicket.class, id); // Retrieve the Flight entity by its ID
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
