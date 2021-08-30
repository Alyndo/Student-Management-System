package com.alwyncodebuffer.sms.repository;

import com.alwyncodebuffer.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
