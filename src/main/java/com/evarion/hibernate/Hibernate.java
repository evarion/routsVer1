package com.evarion.hibernate;

import com.evarion.hibernate.models.Auto;
import com.evarion.hibernate.models.User;
import com.evarion.hibernate.services.UserService;

import java.sql.SQLException;

public class Hibernate {
    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = new User("Masha", 26);
        userService.saveUser(user);
        Auto ferrari = new Auto("Ferrari", "red");
        ferrari.setUser(user);
        user.addAuto(ferrari);
        Auto ford = new Auto("Ford", "black");
        ford.setUser(user);
        user.addAuto(ford);
        userService.updateUser(user);
    }
}
