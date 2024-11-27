package com.jbk.dao;

import com.jbk.entities.Student;
import com.jbk.entities.User;

import java.util.List;

public interface StudentDao {
    int saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean deleteById(int id);
    boolean update(Student student);
    int saveMultipleStudents(List<Student> students);

}
