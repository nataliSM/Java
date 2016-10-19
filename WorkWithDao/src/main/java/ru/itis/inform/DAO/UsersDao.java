package ru.itis.inform.DAO;

import ru.itis.inform.models.User;

import java.util.List;


/**
 * Created by Natalia on 05.09.16.
 */
public interface UsersDao {
    List <User> findAll();
    long save(User user);
    User find(int id);

}
