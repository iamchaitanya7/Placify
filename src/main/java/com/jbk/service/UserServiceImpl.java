package com.jbk.service;

import com.jbk.dao.UserDao;
import com.jbk.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // Use dependency injection

    //POST API: /user/createUser: Creates a new user record.
    @Override
    public int createUser(User user) {
        return userDao.createUser(user);
    }


    //POST API /auth/login: Authenticates a user based on the provided credentials.
    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Valid credentials
        }
        return false; // Invalid credentials
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(String username) {
        return userDao.deleteUser(username);
    }
}

