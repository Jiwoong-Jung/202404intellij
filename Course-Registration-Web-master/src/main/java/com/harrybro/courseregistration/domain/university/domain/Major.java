package com.harrybro.courseregistration.domain.university.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private College college;

    @OneToMany(mappedBy = "major", cascade = CascadeType.REMOVE)
    private List<Lecture> lectures;

    @Builder
    public Major(String name, College college) {
        this.name = name;
        this.college = college;
        this.lectures = new ArrayList<>();
    }

}
