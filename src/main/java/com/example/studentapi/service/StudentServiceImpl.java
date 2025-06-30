package com.example.studentapi.service;

import com.example.studentapi.Repository.StudentRepository;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private  StudentRepository studentRepo;


    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        // Check if student with given ID exists
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

        // Update fields
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        return studentRepo.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

        studentRepo.deleteById(id);
    }
}
