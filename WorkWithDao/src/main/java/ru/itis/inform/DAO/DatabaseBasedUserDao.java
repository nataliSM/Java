package ru.itis.inform.DAO;

import ru.itis.inform.models.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.sql.*;
import java.util.concurrent.SynchronousQueue;
import java.util.logging.*;


/**
 * Created by Natalia on 23.09.16.
 */
public class DatabaseBasedUserDao implements UsersDao {
    private  Connection connection;

    public DatabaseBasedUserDao() {
        initialize();


    }

    private void initialize()
    {
        Connection connection = null;
        String url = "jdbc:postgresql://127.0.0.1:5432/javaServlet";
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

    }

    @Override
    public List<User> findAll() {

        List <User> usersListFromDataBase =  new ArrayList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet result = null;
        try {
             result = statement.executeQuery("SELECT * FROM users");
            while (result.next())
            {
                Integer id   = result.getInt("id");
                String name  = result.getString("name");
                Integer age  = result.getInt("age");
                String city  = result.getString("city");
                //User user    = new User(id, name,age,city);

                //usersListFromDataBase.add(user);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return usersListFromDataBase;
    }

   


    @Override
    public long save(User user) {
        int id = -1;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet result = null;
        try {
            id = statement.executeUpdate("INSERT  INTO users( name, age, city ) VALUES ('"+ user.getName() +  "', "+ user.getAge() +", '"+ user.getCity() +"');");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
        }catch (SQLException ex){

        }
            return id;
    }
    

        @Override
    public User find(int id) {


        return null;
    }
}
