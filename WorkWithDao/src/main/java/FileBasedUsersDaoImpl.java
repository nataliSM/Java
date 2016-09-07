import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by Natalia on 05.09.16.
 */
public class FileBasedUsersDaoImpl implements UsersDao {
    private File file;
   private static final  String FILENAME = "user.txt";

    public FileBasedUsersDaoImpl() {
        initialize();
    }

    private void initialize(){
        Path filePath = Paths.get(FILENAME);
        file = new File(filePath.toString());
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public List<User> findAll() {
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
        String[] usersArr= users.get(0).split(";");
        for (String user : usersArr) {
            String[] userData = user.split(":");
        }

        List<User> result = new ArrayList<>();

        for (String info : usersArr) {

            String [] infoParts = info.split(":");

            result.add(  new User( infoParts[0], Integer.parseInt(infoParts[1]) ) );
        }

        //System.out.println(Arrays.toString(usersArr));
        System.out.println(result);
        System.out.println(result.size());


            return null;

    }



    public void save(User user) {


       try {

           FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);

           String name = user.getName();
           int id = user.getId();

           String fullString = name +":" + id + ";";

           try{
               Files.write(file.toPath(), fullString.getBytes(Charset.forName("UTF-8")), StandardOpenOption.WRITE,StandardOpenOption.APPEND);

           }finally {

           }





       }catch (IOException e){
           e.printStackTrace();
       }
    }


        public User find(int id) {
//            List<String> users = new ArrayList<>();
//            try {
//                BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
//                String line;
//                while((line = reader.readLine()) != null ){
//                    users.add(line);
//                }
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }




        return null ;
    }
}
