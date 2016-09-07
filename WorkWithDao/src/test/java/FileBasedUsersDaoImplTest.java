import junit.framework.TestCase;

/**
 * Created by Natalia on 05.09.16.
 */
public class FileBasedUsersDaoImplTest extends TestCase {
    public void testFindAll() throws Exception {
    UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
        fileBasedUsersDao.findAll();
    }

    public void testSave() throws Exception {
        User user = new User("Nikita", id);


        UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
        fileBasedUsersDao.save(user);



         user = new User("Nikitak", id);
        fileBasedUsersDao.save(user);

    }

    public void testFind() throws Exception {

    }

}