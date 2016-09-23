package ru.itis.inform.servlet;

import ru.itis.inform.DAO.FileBasedUsersDaoImpl;
import ru.itis.inform.DAO.UsersDao;
import ru.itis.inform.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



/**
 * Created by Natalia on 17.09.16.
 */
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {
            UsersDao dao = new FileBasedUsersDaoImpl();
            List<User> userList = dao.findAll();
            req.setAttribute("userList", userList);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/users.jsp");
            rd.forward(req, resp);
        }
    }
}