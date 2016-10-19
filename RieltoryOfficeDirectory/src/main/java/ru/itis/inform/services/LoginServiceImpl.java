package ru.itis.inform.services;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.commons.codec.digest.DigestUtils;
import ru.itis.inform.DAOs.UserDAO;
import ru.itis.inform.DAOs.UserDaoImpl;
import ru.itis.inform.models.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.Cookie;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Natalia on 09.10.16.
 */
public class LoginServiceImpl implements LoginService
{
    private String currentToken;

    public static String md5Apache(String password) {
        String md5Hex = DigestUtils.md5Hex(password);

        return md5Hex;
    }

    @Override
    public boolean verifyUser(String username, String password) {
        UserDAO userDAO = new UserDaoImpl();
        User user = userDAO.findUser(username);

        if (user != null) {
            generateToken();
            return true;
        }
        return false;


    }

    @Override
    public ArrayList<Cookie> generateCookies() {
        if (this.currentToken == null)
        {
            throw new IllegalArgumentException();
        }
        Cookie cookie = new Cookie(this.currentToken);
        cookie.setMaxAge(30*60);
        ArrayList<Cookie>  cookieArrayList = new ArrayList<Cookie>();
        cookieArrayList.add(cookie);
    }

    private void generateToken ()
    {
        Random random = new SecureRandom();
        char[] result = new char[32];
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        this.currentToken = new String(result);
    }


    }



