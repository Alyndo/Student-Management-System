package com.alwyncodebuffer.sms.service;

import com.alwyncodebuffer.sms.entity.Student;
import com.alwyncodebuffer.sms.error.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> fetchStudentList();

    Student fetchStudentById(Long studentId) throws StudentNotFoundException;

    Student updateStudent(Long studentId, Student student);

    void deleteStudentById(Long studentId);
}
