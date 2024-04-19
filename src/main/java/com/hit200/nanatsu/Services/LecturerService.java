package com.hit200.nanatsu.Services;

import com.hit200.nanatsu.Modelling.Lecturer;
import com.hit200.nanatsu.Repositories.LecturerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LecturerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LecturerRepository lecturerRepository; // Assuming you have a repository interface for Lecturer

    // Create operation
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    // Read operation
    public Lecturer getLecturerById(String lecturerId) {
        return entityManager.find(Lecturer.class, lecturerId);
    }

    // Update operation
    public Lecturer updateLecturer(Lecturer lecturer) {
        return entityManager.merge(lecturer);
    }

    // Delete operation
    public void deleteLecturer(String lecturerId) {
        Lecturer lecturer = entityManager.find(Lecturer.class, lecturerId);
        if (lecturer != null) {
            entityManager.remove(lecturer);
        }
    }

    // Additional operations
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    // You can add more methods as needed for specific queries or operations
}