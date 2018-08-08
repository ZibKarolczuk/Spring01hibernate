package pl.coderslab.spring01hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernate.dao.PersonDao;
import pl.coderslab.spring01hibernate.entity.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @GetMapping("/addform")
    public String addPerson(){
        return "person/addform";
    }

    @PostMapping("/addform")
    public String addPersonPost(@RequestParam String login,
                                @RequestParam String email,
                                @RequestParam String password){
        Person p = new Person(login, email, password);
        this.personDao.create(p);

        return "person/success";
    }

    @GetMapping("/addformtaglib")
    public String addPersonTaglib(Model model){
        model.addAttribute("person", new Person());

        return "person/addformtaglib";
    }

    @PostMapping("/addformtaglib")
    public String addPersonTaglibPost(@ModelAttribute Person person){
        this.personDao.create(person);

        return "person/success";
    }

    @ModelAttribute("countries")
    public String[] countries(){
//        List<String> l = new ArrayList<>();
//        l.add("Polska");
//        l.add("Niemcy");

        String[] li = {"Polska", "Niemcy"};

        return li;
    }
}
