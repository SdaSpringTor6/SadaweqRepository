package com.example.model;

public class Order {

    private int id;
    private int price;

    public Order(){

    }

    public Order(int id, int price, String title, User user) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.user = user;
    }

    private String title;
    private User user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
