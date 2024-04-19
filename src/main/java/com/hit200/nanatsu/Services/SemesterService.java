package com.hit200.nanatsu.Services;

import com.hit200.nanatsu.Modelling.Semester;
import com.hit200.nanatsu.Repositories.SemesterRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class SemesterService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SemesterRepository semesterRepository; // Assuming you have a repository interface for Semester

    // Create operation
    public Semester createSemester(Semester semester) {
        return semesterRepository.save(semester);
    }

    // Read operation
    public Semester getSemesterById(Long semesterId) {
        return entityManager.find(Semester.class, semesterId);
    }

    // Update operation
    public Semester updateSemester(Semester semester) {
        return entityManager.merge(semester);
    }

    // Delete operation
    public void deleteSemester(Long semesterId) {
        Semester semester = entityManager.find(Semester.class, semesterId);
        if (semester != null) {
            entityManager.remove(semester);
        }
    }

    // Additional operations
    public List<Semester> getAllSemesters() {
        return semesterRepository.findAll();
    }

    // You can add more methods as needed for specific queries or operations
}