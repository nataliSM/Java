package ru.itis.inform.DAO;

import junit.framework.TestCase;
import ru.itis.inform.models.User;

/**
 * Created by Natalia on 24.09.16.
 */
public class DatabaseBasedUserDaoTest extends TestCase {
    public void testFindAll() throws Exception {
        DatabaseBasedUserDao dao = new DatabaseBasedUserDao();
        System.out.println(dao.findAll());
    }

    public void testSave() throws Exception {
        DatabaseBasedUserDao dao = new DatabaseBasedUserDao();
        User user = new User(20,"Pasha",32,"Kazan");
        dao.save(user);
        System.out.println(dao.findAll());

    }

    public void testFind() throws Exception {

    }

}