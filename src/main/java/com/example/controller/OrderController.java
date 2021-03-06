package com.example.controller;

import com.example.dao.OrderDAO;
import com.example.dao.UserDAO;
import com.example.model.Order;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderDAO orderDAO;
    @Autowired
    UserDAO userDAO;

    @RequestMapping("/list")
    public String orderPage(Model model) {
        model.addAttribute("orders", orderDAO.getOrders());
        return "order";
    }

    @RequestMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("users", userDAO.getUsers());
        return "addOrders";
    }

    @PostMapping("/save")
    public String postAction(Order order, @RequestParam("id") int id) {
        order.setUser(userDAO.getUserById(id));
        order.setId(orderDAO.getOrders().size());
        orderDAO.addOrder(order);
        System.out.println("Added order " + order.getId() + " " +
                order.getTitle() + " " +
                order.getPrice() + " " +
                order.getUser().getFirstName() + " " +
                order.getUser().getLastName());

        return "redirect:list";
    }

}
