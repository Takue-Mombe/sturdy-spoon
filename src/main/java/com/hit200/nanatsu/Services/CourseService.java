package com.hit200.nanatsu.Services;


import com.hit200.nanatsu.Modelling.Courses;
import com.hit200.nanatsu.Repositories.CourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CourseService {


    private final CourseRepository courseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create operation
    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Read operation
    public Courses getCourseById(String courseId) {
        return entityManager.find(Courses.class, courseId);
    }

    // Update operation
    public Courses updateCourse(Courses course) {
        return entityManager.merge(course);
    }

    // Delete operation
    public void deleteCourse(String courseId) {
        Courses course = entityManager.find(Courses.class, courseId);
        if (course != null) {
            entityManager.remove(course);
        }
    }

    // Additional operations
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    // You can add more methods as needed for specific queries or operations
}
