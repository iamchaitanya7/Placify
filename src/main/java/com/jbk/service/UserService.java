package com.jbk.service;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import java.util.List;

public interface UserService {
    int createUser(User user);
    boolean authenticateUser(String username, String password);
    boolean deleteUser(String username);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean updateUser(User user);

    //Additional Method to Authenticate the user
    User loginUser(LoginRequest loginRequest);

    }
