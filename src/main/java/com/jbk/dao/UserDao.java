package com.jbk.dao;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;

import java.util.List;

public interface UserDao {
    int createUser(User user);
    User getUserByUsername(String username);
    public boolean deleteUser(String username);
    public List<User> getAllUsers();
    boolean updateUser(User user);
    User loginUser(LoginRequest loginRequest);


}
