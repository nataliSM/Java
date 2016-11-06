package ru.itis.inform.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Natalia on 05.11.16.
 */
public class RieltoryDataBaseConnection implements DataBaseConnectionServices {
    private  Connection connection;
    @Override
    public Connection getConnection() {
        if (this.connection != null){
            return this.connection;
        }
        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/rieltoryoffice";
        String user = "Natalia";
        String password = "";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            this.connection = connection;
            System.out.println("Connection done");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
