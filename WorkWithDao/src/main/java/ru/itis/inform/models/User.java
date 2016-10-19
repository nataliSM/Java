package ru.itis.inform.models;

/**
 * Created by Natalia on 05.09.16.
 */
public class User implements UserInterface {
    private  int age;
    private String city;
    private String name;
    private int id;

    public User(String name, Integer age, String city)
    {
        this.name = name;
        //this.id = id;
        this.city = city;
        this.age = age;

    }

    public String getCity(){
        return  this.city ;

    }

    public void setCity(String city){
        this.city = city;
    }

    public  User (){

    }
    public User(String name)
    {

        this.name = name;
    }



    public String getName()
    {

        return this.name;
    }


    public void setName(String name)
    {

        this.name = name;
    }


    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {

        this.age = age;
    }


    public int getId()
    {

        return this.id;
    }

    public void setId(int id)
    {

        this.id = id;
    }



    @Override
    public String toString() {
        return
                "name:" + name + " " +
                "id:" + id + " " + "age:" + age + " " +  "city:" + city + "\n";
    }


}
