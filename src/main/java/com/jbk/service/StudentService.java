package com.jbk.service;

import com.jbk.entities.Student;
import java.util.List;

public interface StudentService {
    int registerStudent (Student student);
    List<Student> getAllStudents ();
    Student getStudentById(int id);
    boolean deleteStudentById (int id);
    boolean updateStudent (Student student);
    int addMultipleStudents(List<Student> students);

}