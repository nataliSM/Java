package ru.itis.inform.DAOs;

import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.models.User;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 10.10.16.
 */
public class UserDaoImplTest {
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        this.userDAO = new UserDaoImpl();

    }

    @Test
    public void findUser() throws Exception {
        User user = new User("Natasha", "123");
        boolean actual = userDAO.findUser(user);
        assertTrue(actual);
    }

    @Test
    public void save() throws Exception {

    }

}