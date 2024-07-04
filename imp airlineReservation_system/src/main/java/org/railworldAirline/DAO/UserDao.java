package org.railworldAirline.DAO;

import org.railworldAirline.model.BookTicket;
import org.railworldAirline.model.User;

public interface UserDao {


    public boolean authenticateUser(String userName , String password);

    public void userLogin(User user);

    public void bookTicket(BookTicket bookTicket);

    public void cancelTicket(long id);

}
