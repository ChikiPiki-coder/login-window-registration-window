package com.webapp.tamik.mywebappversion2spring.controllers;

import com.webapp.tamik.mywebappversion2spring.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("authorization")
public class AuthorizationWindowController {
    List<Person> persons = new ArrayList<Person>();

    @GetMapping
    public String authorizationWindow(Model model) {
        model.addAttribute("person", new Person());
        return "authorization";
    }

    @PostMapping()
    public String signIn(@ModelAttribute("person") Person person) {
        boolean f=false;
        for(Person i:persons){
            if(i.getStatus().equals(person.getStatus())&&i.getName().equals(person.getName())&&i.getPassword().equals(person.getPassword()))
                f=true;
        }
        if (f) {
            if (person.getStatus().equals("admin"))
                return "forAdmin/admin";
            else if (person.getStatus().equals("user")) {
                System.out.println(persons.toString());
                return "forUser/user";
            }
            else {
                return "errorAuthorization";
            }
        } else {
            return "errorAuthorization";
        }
    }

    @GetMapping("new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "new";
    }

    @PostMapping("new")
    public String signUp(@ModelAttribute("person") Person person) {
        persons.add(person);
        if (person.getStatus().equals("admin"))
            return "forAdmin/admin";
        else
            return "forUser/user";

    }

}
