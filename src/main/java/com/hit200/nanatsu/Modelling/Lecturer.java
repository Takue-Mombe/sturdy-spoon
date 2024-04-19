package com.hit200.nanatsu.Modelling;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity@Table(name = "lecturer")
@Getter@Setter
public class Lecturer {
    @Id
    private String lecturer_id;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @OneToMany(mappedBy = "lecturer") // One lecturer can have multiple courses
    private List<Courses> courses;
    @Column
    private String department;
}
