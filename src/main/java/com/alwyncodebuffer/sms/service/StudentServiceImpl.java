package com.alwyncodebuffer.sms.service;

import com.alwyncodebuffer.sms.entity.Student;
import com.alwyncodebuffer.sms.error.StudentNotFoundException;
import com.alwyncodebuffer.sms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetchStudentById(Long studentId) throws StudentNotFoundException {
        Optional<Student> student= studentRepository.findById(studentId);

        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student Not Available");
        }

        return student.get();
    }

    @Override
    public Student updateStudent(Long studentId, Student student) {
        Student studDB = studentRepository.findById(studentId).get();

        if(Objects.nonNull(student.getStudentName()) &&
                !"".equalsIgnoreCase(student.getStudentName())) {
            studDB.setStudentName(student.getStudentName());
        }

        if(Objects.nonNull(student.getStudentGender()) &&
                !"".equalsIgnoreCase(student.getStudentGender())) {
            studDB.setStudentGender(student.getStudentGender());
        }

        if(Objects.nonNull(student.getStudentEmail()) &&
                !"".equalsIgnoreCase(student.getStudentEmail())) {
            studDB.setStudentEmail(student.getStudentEmail());
        }

        return studentRepository.save(studDB);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
