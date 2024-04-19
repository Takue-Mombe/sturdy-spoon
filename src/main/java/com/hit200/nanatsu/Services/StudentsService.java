package com.hit200.nanatsu.Services;


import com.hit200.nanatsu.Modelling.Students;
import com.hit200.nanatsu.Repositories.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private StudentRepository studentsRepository; // Assuming you have a repository interface for Students

    // Create operation
    public Students createStudent(Students student) {
        return studentsRepository.save(student);
    }

    // Read operation
    public Students getStudentById(String regNumber) {
        return entityManager.find(Students.class, regNumber);
    }

    // Update operation
    public Students updateStudent(Students student) {
        return entityManager.merge(student);
    }

    // Delete operation
    public void deleteStudent(String regNumber) {
        Students student = entityManager.find(Students.class, regNumber);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    // Additional operations
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    // You can add more methods as needed for specific queries or operations
}
