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
    public Student fetchStudentById(Long id) throws StudentNotFoundException {
        Optional<Student> student= studentRepository.findById(id);

        if(!student.isPresent()) {
            throw new StudentNotFoundException("Student Not Available");
        }

        return student.get();
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student studDB = studentRepository.findById(id).get();

        if(Objects.nonNull(student.getName()) &&
                !"".equalsIgnoreCase(student.getName())) {
            studDB.setName(student.getName());
        }

        if(Objects.nonNull(student.getGender()) &&
                !"".equalsIgnoreCase(student.getGender())) {
            studDB.setGender(student.getGender());
        }

        if(Objects.nonNull(student.getAdmissionTime()) &&
                !"".equalsIgnoreCase(student.getAdmissionTime())) {
            studDB.setAdmissionTime(student.getAdmissionTime());
        }

        return studentRepository.save(studDB);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
