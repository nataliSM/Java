package ru.itis.inform.DAOs;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Address;
import ru.itis.inform.models.rieltoryModel.Trader;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Natalia on 05.11.16.
 */
public class AddressDAOImpl implements AddressDAO {
    private Connection connection;

    public AddressDAOImpl() {
        DataBaseConnectionServices databaseConnection = ServiceFactory.getInstance().getRieltoryDataBaseConnection();
        this.connection = databaseConnection.getConnection();
    }

    @Override
    public Address getAddress(int id) {
        return null;
    }
}
