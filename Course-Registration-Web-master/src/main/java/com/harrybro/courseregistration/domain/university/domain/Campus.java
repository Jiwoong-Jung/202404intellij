package com.harrybro.courseregistration.domain.university.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "campus", cascade = CascadeType.REMOVE)
    private List<College> college;

    @Builder
    public Campus(String name) {
        this.name = name;
        this.college = new ArrayList<>();
    }

}
