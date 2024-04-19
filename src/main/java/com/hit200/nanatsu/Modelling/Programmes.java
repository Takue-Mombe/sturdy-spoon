package com.hit200.nanatsu.Modelling;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "programmes")
@Getter@Setter
public class Programmes {
    @Id@Column
    private String programmeId;
    @Column
    private String programmeName;
    @Column
    private String School;
    @OneToMany(mappedBy = "programme")
    private List<Students> students;
    @OneToMany(mappedBy = "programme")
    private List<Courses> courses;
}
