package ru.itis.inform.DAOs;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.*;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Natalia on 05.11.16.
 */
public class OffersDAOImpl  implements  OffersDAO{
private Connection connection;

    public OffersDAOImpl(){
        DataBaseConnectionServices dataBaseConnectionServices = ServiceFactory.getInstance().getRieltoryDataBaseConnection();
        this.connection =  dataBaseConnectionServices.getConnection();
    }
    @Override
    public List<Offer> getAllOffersWithParams(int countOfRoom, String condition, String repair, String cityName) {
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM full_offers WHERE city_name = ? AND count_of_room = ? AND condition = ? AND repair = ?"; ;
        List<Offer> offers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityName);
            preparedStatement.setInt(2,countOfRoom);
            preparedStatement.setString(3,condition);
            preparedStatement.setString(4,repair);
            preparedStatement.executeQuery();
            ResultSet resultSet = null;
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    Offer offer = new Offer();
                    Integer id = resultSet.getInt("id");
                    String cost = resultSet.getString("cost");
                    Integer traiderId = resultSet.getInt("trader_id");
                    String traderName = resultSet.getString("trader_name");
                    String traderPhone = resultSet.getString("trader_phone");
                    Integer addressId = resultSet.getInt("address_id");
                    Integer cityId = resultSet.getInt("city_id");
                    Integer streetId = resultSet.getInt("street_id");
                    String streetName = resultSet.getString("street_name");
                    Integer house = resultSet.getInt("house");
                    Integer flat = resultSet.getInt("flat");
                    Integer featuresId = resultSet.getInt("features_id");

                    offer.setId(id);
                    offer.setCost(cost);

                    Address address =  new Address();
                    address.setId(addressId);
                    address.setFlat(flat);
                    address.setHouse(house);
                    City city = new City(cityId,cityName);
                    address.setCity(city);
                    Street street = new Street(streetId,streetName,city);
                    address.setStreet(street);

                    offer.setAddress(address);

                    Trader trader = new Trader(traiderId,traderName,traderPhone);
                    offer.setTrader(trader);

                    Feature feature = new Feature(featuresId,countOfRoom,condition,repair);
                    offer.setFeature(feature);

                    offers.add(offer);


                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return offers;
    }
}
