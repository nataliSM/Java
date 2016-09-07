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

        User user = new User("Nikita", 898);


        UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
        fileBasedUsersDao.save(user);



         user = new User("Nikitak",998);
        fileBasedUsersDao.save(user);

    }

    public void testFind() throws Exception {

    }

}