package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("cp1251");
        OfferseGeneratorService offerseGeneratorService = ServiceFactory.getInstance().getOfferseGeneratorService();
        String numberOfRooms = request.getParameter("numberOfRooms");
        String condition = request.getParameter("condition");
        String repair = request.getParameter("repair");
        String city = request.getParameter("city");
        List<Offer> offerList= offerseGeneratorService.generateOfferces(Integer.valueOf(numberOfRooms),condition,repair,city);
        request.setAttribute("offerList", offerList);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
