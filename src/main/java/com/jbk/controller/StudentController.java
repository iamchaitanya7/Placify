package com.jbk.controller;

import com.jbk.entities.Student;
import com.jbk.entities.User;
import com.jbk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public String registerStudent (@RequestBody Student student) {
        int status = studentService.registerStudent (student);
        switch (status){
            case 1:
                return "Student Registered Successfully..!";
            case 2:
                return "Student Already Exists.!";
            case 3:
                return "Something Error Occured.!";
            default:
                return "Error!";
        }
    }


    @GetMapping("/allStudents")
    public List<Student> getAllStudents () {
        List<Student> students = studentService.getAllStudents ( );
        return students;
    }

    @GetMapping("/getStudentById/{id}")
    public Object getStudentById(@PathVariable int id) {
        try {
            Student student = studentService.getStudentById(id);
            if (student != null) {
                return student; // Return the student details if found
            } else {
                return "Student not found with ID: " + id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while fetching the student.";
        }
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent (@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudentById(id);
        try {
            if (isDeleted) {
                return "Student deleted successfully!";
            }
            return "Student not found!";
        }
        catch (Exception e) {
            return "Something Error Occured!";
        }
    }

    @PutMapping("/updateStudent")
    public String updateStudent(@RequestBody Student student) {
        boolean updatedStudent = studentService.updateStudent(student);
        try {
            if (updatedStudent) {
                return "Students Details Updated Successfully";
            } else {
                return "Student Updation Failed or Student Does not Exist!";
            }
        } catch (Exception e) {
            return "Something Error Occured!";
        }

    }

    @PostMapping("/addMultipleStudents")
    public Object addMultipleStudents(@RequestBody List<Student> students) {
        try {
            int addedCount = studentService.addMultipleStudents(students);
            return "Students added successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "An error occurred while adding Multiple students.";
        }
    }
}

