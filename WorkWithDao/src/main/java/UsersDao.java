import java.util.List;

/**
 * Created by Natalia on 05.09.16.
 */
public interface UsersDao {
    List <User> findAll();
    void save(User user);
    User find(int id);

}
