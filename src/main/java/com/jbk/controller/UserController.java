package com.jbk.controller;

import com.jbk.entities.User;
import com.jbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //POST API: /user/createUser: Creates a new user record.
    @PostMapping("/create-user")
    public String createUser(@RequestBody User user){
        int status = userService.createUser(user);
        switch (status) {
            case 1:
                return "User created successfully!";
            case 2:
                return "User already exists!";
            case 3:
                return "Error occurred while creating user.";
            default:
                return "Unexpected error.";
        }
    }

    //POST API /auth/login: Authenticates a user based on the provided credentials.
    @PostMapping("/login")
    public String login (@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticateUser(username, password);
        if (isAuthenticated) {
            return "Login successful!";
        } else {
            return "Invalid username or password.";
        }
    }


    // GET API: Retrieves a list of all registered users.
    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    // GET API: Fetches a user by username.
    @GetMapping("/getUser/{username}")
    public Object getUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return user;
        } else {
            return "User: " + username + " Not Found.";
        }
    }

    // PUT API: Updates user details.
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        boolean isUpdated = userService.updateUser(user);
        if (isUpdated) {
            return "User updated successfully.";
        } else {
            return "User not found or update failed.";
        }
    }

    // DELETE API: Deletes a user by username.
    @DeleteMapping("/deleteUser/{username}")
    public String deleteUser (@PathVariable String username) {
        boolean isDeleted = userService.deleteUser(username);
        if (isDeleted) {
            return "User deleted successfully.";
        } else {
            return "User not found.";
        }
    }
}
