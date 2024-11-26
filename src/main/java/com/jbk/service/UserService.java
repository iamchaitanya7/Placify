package com.jbk.service;

import com.jbk.entities.User;
import java.util.List;

public interface UserService {
    int createUser(User user);
    boolean authenticateUser(String username, String password);
    boolean deleteUser(String username);
    List<User> getAllUsers();
    User getUserByUsername(String username);
    boolean updateUser(User user);

}
