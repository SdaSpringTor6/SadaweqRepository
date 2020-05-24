package com.example.controller;

import com.example.dao.UserDAO;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Controller
@SessionScope
public class UserController {

    @PostConstruct
    public void init(){
        System.out.println("zainicjalizowałem strone");
    }



    @Autowired
    UserDAO userDao;

    @RequestMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "index";
    }
    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDao.getUserById(id));
        return "index";
    }
    @RequestMapping("/post")
    public String postPage(Model model) {
        model.addAttribute("user", new User());
        return "post";
    }
    @PostMapping("/save")
    public String postAction(User user){
        user.setId(5);
        return "index";
    }

}