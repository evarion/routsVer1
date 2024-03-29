package com.evarion.library.hibernateLibrary.services;

import com.evarion.library.hibernateLibrary.dao.UserDao;
import com.evarion.library.hibernateLibrary.models.Auto;
import com.evarion.library.hibernateLibrary.models.User;

import java.util.List;

public class UserService {
    private UserDao usersDao = new UserDao();

    public UserService() {
    }

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }


}
