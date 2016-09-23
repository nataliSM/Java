package ru.itis.inform.DAO;

import ru.itis.inform.models.User;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;



/**
 * Created by Natalia on 05.09.16.
 */
public class FileBasedUsersDaoImpl implements UsersDao {
    private File file;
   private static final  String FILENAME = "/Users/Natalia/spiridonova/Java/WorkWithDao/user.txt";
    private static int maxId;
    public FileBasedUsersDaoImpl() {

        initialize();
    }

    private void initialize(){
        Path filePath = Paths.get(FILENAME);
        file = new File(filePath.toString());
        if (maxId == 0){
            maxId = getMaxId();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public List<User> findAll() {
        List<String> users = getAllUserStringList();
        List <User> userList = new ArrayList<>();
        for(String user : users ) {

            String[] currentUser = user.split(",");
            User userNew =  new User();
            userNew.setName(currentUser[0]);
            userNew.setId(Integer.valueOf(currentUser[1]));
            userList.add(userNew);
        }


            return userList;

    }

    private List<String> getAllUserStringList(){
        List<String> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
            String line;
            while((line = reader.readLine()) != null  ){
                users.add(line);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;

    }

    private int getMaxId(){
        List<String> users = getAllUserStringList();
        int lastIndex = users.size() -1;
        if(users.size() == 0){
            return  0;
        }
        String usersString = users.get(lastIndex);
        String[] userFields = usersString.split(",");
        return Integer.valueOf(userFields[1]);
    }

    public void save(User user) {
        String name = user.getName();
        int id = maxId + 1;
        String fullString = name +"," + id + "\n";

        try{
            Files.write(file.toPath(), fullString.getBytes(Charset.forName("UTF-8")), StandardOpenOption.WRITE,StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();

        }finally {
            maxId = id;
        }
    }


    public User find(int id) {
        List<String> users = getAllUserStringList();
        for(String user : users){
            String[] newUser =user.split(",");
            if(id == Integer.valueOf(newUser[1])){
                User foundedUser =new User();
                foundedUser.setName(newUser[0]);
                foundedUser.setId(Integer.valueOf(newUser[1]));
                return foundedUser;

            }

        }
        return null ;
    }
}
