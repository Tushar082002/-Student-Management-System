package com.example.studentapi.service;


import com.example.studentapi.model.Student;
import com.example.studentapi.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student add(Student student){
        return  repository.save(student);
    }
    public List<Student> getAll(){
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
