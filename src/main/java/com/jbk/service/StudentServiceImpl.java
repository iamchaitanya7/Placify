package com.jbk.service;

import com.jbk.dao.StudentDao;
import com.jbk.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public int registerStudent(Student student) {
        return studentDao.saveStudent (student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public boolean deleteStudentById(int id) {
        return studentDao.deleteById(id);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int addMultipleStudents(List<Student> students) {
        return studentDao.saveMultipleStudents(students); // Delegate to the DAO layer
    }
}

