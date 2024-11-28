package com.jbk.entities;

import com.jbk.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", nullable = false, unique = true)
    @NotBlank(message = "Invalid Username!")
    private String username;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password must be 8-20 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character."
    )
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "Invalid Question!")
    @Column(name = "question", nullable = false)
    private String question;

    @NotBlank(message = "Invalid Answer!")
    @Column(name = "answer", nullable = false)
    private String answer;

    @NotBlank(message = "Invalid Role!")
    @Column(name = "role", nullable = false)
    private String role;

    // Constructors, getters, and setters
    public User () {
    }

    public User (String username, String password, String question, String answer, String role) {
        this.username = username;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.role = role; 
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion (String question) {
        this.question = question;
    }

    public String getAnswer () {
        return answer;
    }

    public void setAnswer (String answer) {
        this.answer = answer;
    }

    public String getRole () {
        return role;
    }

    public void setRole (String role) {
        this.role = role;
    }

    @Override
    public String toString () {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
