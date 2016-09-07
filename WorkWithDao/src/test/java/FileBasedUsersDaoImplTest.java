import junit.framework.TestCase;

import java.util.List;

/**
 * Created by Natalia on 05.09.16.
 */
public class FileBasedUsersDaoImplTest extends TestCase {
    public void testFindAll() throws Exception {
    UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
       List <User> allUsers = fileBasedUsersDao.findAll();
        for(User usr : allUsers){
            System.out.println(usr.toString());
        }
    }

    public void testSave() throws Exception {
        UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
        User user = new User("Nikita");
        fileBasedUsersDao.save(user);

        user = new User("Nikitak");
        fileBasedUsersDao.save(user);

        user = new User("Natasha");
        fileBasedUsersDao.save(user);


    }

    public void testFind() throws Exception {
        UsersDao fileBasedUsersDao = new FileBasedUsersDaoImpl();
        System.out.print(fileBasedUsersDao.find(2));

    }

}