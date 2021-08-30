package com.alwyncodebuffer.sms.controller;

import com.alwyncodebuffer.sms.entity.Student;
import com.alwyncodebuffer.sms.error.StudentNotFoundException;
import com.alwyncodebuffer.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchStudentList(){
        return studentService.fetchStudentList();
    }

    @GetMapping("/students/{id}")
    public Student fetchStudentById(@PathVariable("id") Long id) throws StudentNotFoundException {
        return studentService.fetchStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public String  deleteStudentById(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return "Student deleted Successfully!!";
    }

}
