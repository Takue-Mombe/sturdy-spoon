package com.hit200.nanatsu.Modelling;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity@Table(name = "semester")
@Getter@Setter
public class Semester {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long semester_id;
    @Column
    private String semester_name;
}
