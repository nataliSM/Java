package ru.itis.inform.models;

/**
 * Created by Natalia on 05.09.16.
 */
public class User implements UserInterface {
    private String name;
    private int id;

    public User() {

    }

    public User(String name) {

        this.name = name;

    }



    public String getName() {

        return this.name;

    }


    public int getId() {

        return this.id;

    }

    public void setId(int id) {
        
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", id=" + id ;
    }
}
