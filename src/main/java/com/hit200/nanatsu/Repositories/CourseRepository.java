package com.hit200.nanatsu.Repositories;

import com.hit200.nanatsu.Modelling.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,String> {
}
