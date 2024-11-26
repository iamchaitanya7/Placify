package com.jbk.dao;

import com.jbk.entities.User;

import java.util.List;

public interface UserDao {
    int createUser(User user);
    User getUserByUsername(String username);
    public boolean deleteUser(String username);
    public List<User> getAllUsers();
    //User getUserByUsername(String username);
    boolean updateUser(User user);

}
