package com.hit200.nanatsu.Services;

import com.hit200.nanatsu.Modelling.Programmes;
import com.hit200.nanatsu.Repositories.ProgrammeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProgrammesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProgrammeRepository programmesRepository; // Assuming you have a repository interface for Programmes

    // Create operation
    public Programmes createProgramme(Programmes programme) {
        return programmesRepository.save(programme);
    }

    // Read operation
    public Programmes getProgrammeById(String programmeId) {
        return entityManager.find(Programmes.class, programmeId);
    }

    // Update operation
    public Programmes updateProgramme(Programmes programme) {
        return entityManager.merge(programme);
    }

    // Delete operation
    public void deleteProgramme(String programmeId) {
        Programmes programme = entityManager.find(Programmes.class, programmeId);
        if (programme != null) {
            entityManager.remove(programme);
        }
    }

    // Additional operations
    public List<Programmes> getAllProgrammes() {
        return programmesRepository.findAll();
    }

    // You can add more methods as needed for specific queries or operations
}

