package ru.itis.inform.factories;

import ru.itis.inform.DAOs.*;

/**
 * Created by Natalia on 05.11.16.
 */
public class RieltoryFactory {
    private static RieltoryFactory ourInstance = new RieltoryFactory();

    public static RieltoryFactory getInstance() {
        return ourInstance;
    }

    public AddressDAO getAddressDAO(){
        return new AddressDAOImpl();
    }

     public CityDAO getCityDAO(){
         return new CityDAOImpl();
     }

     public FeaturesDAO getFeaturesDAO(){
         return new FeaturesDAOImpl();
     }

     public OffersDAO getOffersDAO(){
         return new OffersDAOImpl();
     }

     public StreetDAO getStreetDAO(){
         return new StreetDAOImpl();
     }

    public TraderDAO getTraderDAO(){
        return new TraderDAOImpl();
    }
}
