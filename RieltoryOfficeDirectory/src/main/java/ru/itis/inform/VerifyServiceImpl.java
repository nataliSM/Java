package ru.itis.inform;

import ru.itis.inform.DAOs.UserDAO;
import ru.itis.inform.models.User;

/**
 * Created by Natalia on 21.10.16.
 */
public class VerifyServiceImpl implements VerifyService {

    @Override
    public boolean verifyUser(int id, String token) {
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        User user = userDAO.findUser(id);
        if (user == null) {
            return false;

        }

        if (!user.getToken().equals(token)) {
            return false;
        }

        return true;
    }
}
