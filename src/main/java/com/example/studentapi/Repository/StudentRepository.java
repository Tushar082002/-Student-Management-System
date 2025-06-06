package com.example.studentapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
