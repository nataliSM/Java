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
private OffersDAO offersDAO;

    public OfferceGeneratorServicesImpl() {
    }

    public OfferceGeneratorServicesImpl(OffersDAO offersDAO) {
        this.offersDAO = offersDAO;
    }

    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName)
    {
        OffersDAO offersDAO;

        if (this.offersDAO != null){
            offersDAO = this.offersDAO;
        }
        else{
             offersDAO = RieltoryFactory.getInstance().getOffersDAO();
        }

        return offersDAO.getAllOffersWithParams(numberOfRooms, condition, repair, cityName);
    }

}
