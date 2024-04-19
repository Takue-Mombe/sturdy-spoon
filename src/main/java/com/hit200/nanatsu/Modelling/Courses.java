package com.hit200.nanatsu.Modelling;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "courses")
@Getter@Setter
public class Courses {
    @Id
    private String courseId;
    @Column
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programmes programme;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;

}
