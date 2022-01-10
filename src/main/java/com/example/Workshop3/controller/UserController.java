package main.java.com.example.Workshop3.controller;

import main.java.com.example.Workshop3.Model.UserContact;
import main.java.com.example.Workshop3.util.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {


    @Autowired
    private Contact ct;

    @GetMapping("/")
    public String createUser(Model model){
        UserContact username = new UserContact();
        model.addAttribute("user",username);
        return "contactInfo";
    }

    @PostMapping("/contact")
    //this model attribute will only inject with UserContact object populated from field objects
    public String postUser(@ModelAttribute UserContact user, Model model){

        System.out.println(">>>>>>>>>>>>>>>>>>>");
        System.out.println(user.getId());
        System.out.println(user.getName());

        ct.saveContact(user);
        model.addAttribute("user", user);
        return "contactDetails";

    }

    @GetMapping("/contact/{id}")
    public String getUser(@PathVariable(value="id") String id, Model model){
        model.addAttribute("user",ct.getContactById(id));
        return "contactDetails";
    }
}
