package com.jbk.controller;

import com.jbk.dto.LoginRequest;
import com.jbk.entities.User;
import com.jbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/loginUser")
    public Object deleteUser (@RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.loginUser (loginRequest);
            if (user != null) {
                return user;
            } else {
                return "Invalid username or password";
            }
        } catch (Exception e) {
            e.printStackTrace ( );
            return "An error occurred while processing the request";
        }
    }
}
