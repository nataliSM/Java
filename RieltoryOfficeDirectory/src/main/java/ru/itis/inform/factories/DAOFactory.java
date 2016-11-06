package ru.itis.inform.factories;

import ru.itis.inform.DAOs.UserDAO;
import ru.itis.inform.DAOs.UserDaoImpl;

/**
 * Created by Natalia on 21.10.16.
 */
public class DAOFactory {
    private static DAOFactory ourInstance = new DAOFactory();

    public static DAOFactory getInstance() {

        return ourInstance;
    }

    public UserDAO getUserDAO() {
         return new UserDaoImpl();
    }
}
