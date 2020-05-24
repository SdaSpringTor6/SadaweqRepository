package com.example.controller;

import com.example.dao.OrderDAO;
import com.example.model.Order;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

@Autowired
    OrderDAO orderDAO;
    @RequestMapping("/order")
    public String postPage(Model model) {
        model.addAttribute("orders", orderDAO.getOrders());
        return "order";
    }
}
