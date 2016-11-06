package ru.itis.inform.services;

import ru.itis.inform.DAOs.*;
import ru.itis.inform.factories.RieltoryFactory;
import ru.itis.inform.models.rieltoryModel.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public class OfferceGeneratorServicesImpl implements OfferseGeneratorService{

    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName)
    {
        OffersDAO offersDAO = RieltoryFactory.getInstance().getOffersDAO();

        return offersDAO.getAllOffersWithParams(numberOfRooms, condition, repair, cityName);
    }

}
