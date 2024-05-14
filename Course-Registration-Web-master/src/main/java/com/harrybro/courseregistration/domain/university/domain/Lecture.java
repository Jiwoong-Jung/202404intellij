package com.harrybro.courseregistration.domain.university.domain;

import com.harrybro.courseregistration.domain.university.constant.LectureDay;
import com.harrybro.courseregistration.domain.university.constant.LecturePeriod;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lecturer;

    private int credit;

    @ManyToOne
    private Major major;

    @Enumerated(EnumType.STRING)
    private LectureDay day;

    @Enumerated(EnumType.STRING)
    private LecturePeriod period;

    @Builder
    public Lecture(String name, String lecturer, int credit, Major major, LectureDay day, LecturePeriod period) {
        this.name = name;
        this.lecturer = lecturer;
        this.credit = credit;
        this.major = major;
        this.day = day;
        this.period = period;
    }

}
