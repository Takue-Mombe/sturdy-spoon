package com.hit200.nanatsu.Modelling;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity@Table(name = "students")@Getter@Setter
public class Students {
    @Id
    private String regNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programmes programme;
    @Column
    private String yearEnrolled;

}
