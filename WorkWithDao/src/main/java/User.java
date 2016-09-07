/**
 * Created by Natalia on 05.09.16.
 */
public class User implements UserInterface{
    private String name;
    private int id;

    public User(String name, int id) {

        this.name = name;
        this.id = id;
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


}
