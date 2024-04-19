package com.hit200.nanatsu.Repositories;

import com.hit200.nanatsu.Modelling.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,String> {
}
