package ru.itis.inform.services;

import javax.servlet.http.Cookie;
import java.util.ArrayList;

/**
 * Created by Natalia on 09.10.16.
 */
public interface LoginService {
    boolean verifyUser(String username, String password);
    ArrayList<Cookie> generateCookies();
}
