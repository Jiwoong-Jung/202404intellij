package com.harrybro.courseregistration.domain.university.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.harrybro.courseregistration.domain.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "basket", cascade = CascadeType.REMOVE)
//    private List<Account> accounts;

    @Setter
    @OneToOne(mappedBy = "basket")
    private User user;

    @JsonIgnoreProperties({"major"})
    @ManyToMany
    private List<Lecture> lectures;

    public Basket() {
        this.lectures = new ArrayList<>();
    }

    public void saveLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public void deleteLecture(Lecture lecture) {
        this.lectures.remove(lecture);
    }

}
