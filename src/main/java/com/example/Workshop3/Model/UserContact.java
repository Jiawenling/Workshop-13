package main.java.com.example.Workshop3.Model;

import java.io.Serializable;
import java.util.UUID;

public class UserContact implements Serializable {
    private String name;
    private String email;
    private String phone;
    private String id;


    public String generateHexId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","").substring(0,9);
    }

    public UserContact() {
        this.id = this.generateHexId();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }
}
