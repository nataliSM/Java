package ru.itis.inform.servlets;

import ru.itis.inform.ServiceFactory;
import ru.itis.inform.models.User;
import ru.itis.inform.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Natalia on 09.10.16.
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginService loginService = ServiceFactory.getInstance().getLoginService();

        if (loginService.verifyUser(username, password)) {


            Cookie loginCookie = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null) {
                for (Cookie cookie : cookies) {
                    if (!cookie.getName().equals("username"))
                    {
                        continue;
                    }

                    String cookieUserName = cookie.getValue();
                    loginService.verifyUser(cookieUserName,password);
                }
            }

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            Cookie userNameCookie = new Cookie("username",username);
            Cookie passwordCookie = new Cookie("password", password);
            userNameCookie.setMaxAge(30*60);
            response.addCookie(userNameCookie);

            request.getRequestDispatcher("/home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("error", "Unknown user, please try again");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
