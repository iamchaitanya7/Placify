package com.jbk.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "full_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contact_number", nullable = false, unique = true)
    private String contactNumber;

    @Column(name = "department", nullable = false)
    private String department;

    @Column(name = "graduation_year", nullable = false)
    private String graduationYear;

    public Student () {
    }

    public Student (int id, String name, String email, String password, String contactNumber, String department, String graduationYear) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
        this.department = department;
        this.graduationYear = graduationYear;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getContactNumber () {
        return contactNumber;
    }

    public void setContactNumber (String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDepartment () {
        return department;
    }

    public void setDepartment (String department) {
        this.department = department;
    }

    public String getGraduationYear () {
        return graduationYear;
    }

    public void setGraduationYear (String graduationYear) {
        this.graduationYear = graduationYear;
    }

    @Override
    public String toString () {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", department='" + department + '\'' +
                ", graduationYear='" + graduationYear + '\'' +
                '}';
    }
}
