package ru.itis.inform.services; /**
 * Created by Natalia on 09.10.16.
 */

import java.sql.Connection;
import java.sql.*;




public class DataBaseConnectionServicesImpl implements DataBaseConnectionServices {
    private  Connection connection;


    public Connection getConnection()
    {
        if (this.connection != null){
            return this.connection;
        }
        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/appdb";
        String user = "Natalia";
        String password = "";


        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            this.connection = connection;
            System.out.println("connection done");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return connection;

    }

}
