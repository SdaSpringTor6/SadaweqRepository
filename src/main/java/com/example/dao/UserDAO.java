package com.example.dao;

import com.example.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAO {

    private List<User> users = new ArrayList<>();

    @PostConstruct  //zadzieje sie podczas inicjalizacji beana
    public void init() {
        users.add(new User(0, "Romek", "Boot"));
        users.add(new User(1, "Cypis", "Kaszalot"));
        users.add(new User(2, "Maria", "Magdalena"));
        users.add(new User(3, "Jan", "Paweł"));
        users.add(new User(4, "Adolf", "SamWieszJaki"));
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.get(id);
    }
}