package ru.itis.inform.DAOs;


import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.rieltoryModel.Trader;
import ru.itis.inform.services.DataBaseConnectionServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Natalia on 06.11.16.
 */
public class TraderDAOImpl implements TraderDAO {
    private Connection connection;

    public TraderDAOImpl() {
        DataBaseConnectionServices dataBaseConnectionServices = ServiceFactory.getInstance().getRieltoryDataBaseConnection();
        this.connection = dataBaseConnectionServices.getConnection();
    }

    public Trader getTrader(Integer id)
    {
        String sql = "SELECT *  FROM trader WHERE trader_id = ?;";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("trader_name");
                String phone = resultSet.getString("trader_phone");
                Trader trader = new Trader(id, name, phone);
                return trader;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
