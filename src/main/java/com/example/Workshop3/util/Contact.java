package main.java.com.example.Workshop3.util;

import main.java.com.example.Workshop3.Model.UserContact;
import main.java.com.example.Workshop3.Workshop13Application;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class Contact {


    public void saveContact(UserContact userContact){

        Path paths = Paths.get(Workshop13Application.userPath +"\\"+userContact.getId()+".txt");
        System.out.println(paths.toAbsolutePath());
        System.out.println(userContact.getName());
        System.out.println("saving in progress");
        try{
            Files.writeString(paths, userContact.getName()+System.lineSeparator()+userContact.getEmail()+System.lineSeparator()+userContact.getPhone(), StandardCharsets.UTF_8);
            System.out.println("File is saved!");
        } catch (IOException x) {
            System.err.println(x);
        }
    }


    public UserContact getContactById(String id){
        Path paths = Paths.get(Workshop13Application.userPath+ "\\"+ id+".txt");
        UserContact user = new UserContact();
        try(BufferedReader reader = Files.newBufferedReader(paths, StandardCharsets.UTF_8)){
            String currentLine = null;

            List<String> userInfo = new ArrayList<>();
            while((currentLine = reader.readLine()) != null){//while there is content on the current line
                userInfo.add(currentLine);
            }
            user.setName(userInfo.get(0));
            user.setEmail(userInfo.get(1));
            user.setPhone(userInfo.get(2));



        }catch(IOException ex){
            ex.printStackTrace(); //handle an exception here
        }
        return user;
    }
}



