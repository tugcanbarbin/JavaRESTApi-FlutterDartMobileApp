package com.can.rest.webservices.helloworldwebservices.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int userCount = 0;

    static {
        users.add( new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add( new User(++userCount,"Eve", LocalDate.now().minusYears(25)));
        users.add( new User(++userCount,"Jhon", LocalDate.now().minusYears(20)));
    }


    public List<User> retrieveAllUsers()
    {
        return users;
    }

    public User getUser(Integer id)
    {
        for(int i = 0; i < users.size(); i++)
            if(users.get(i).getId() == id)
                return users.get(i);

        return null;
    }

    public boolean deleteUser(Integer id)
    {
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean createUser(User user)
    {
        if(user.getName() == null || user.getBirthDate() == null)
            return false;
        try
        {
            user.setId(++userCount);
            System.out.println(user + " created");
            users.add(user);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
