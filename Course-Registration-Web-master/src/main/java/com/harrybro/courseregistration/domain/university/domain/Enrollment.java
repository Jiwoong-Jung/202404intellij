package com.harrybro.courseregistration.domain.university.domain;

import com.harrybro.courseregistration.domain.user.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @OneToOne(mappedBy = "enrollment")
    private User user;

    @ManyToMany
    private List<Lecture> lectures;

    public Enrollment() {
        this.lectures = new ArrayList<>();
    }

    public boolean saveLecture(Lecture lecture) {
        if (validation(lecture)) {
            this.lectures.add(lecture);
            return true;
        }
        return false;
    }

    private boolean validation(Lecture lecture) {
        for (Lecture savedLecture : this.lectures) {
            if (savedLecture.equals(lecture)) {
                throw new IllegalArgumentException("이미 수강 신청된 강의입니다.");
            }
        }

        String lectureDay = lecture.getDay().getValue();
        for (Lecture savedLecture : this.lectures) {
            if (savedLecture.getDay().getValue().contains(lectureDay) || lectureDay.contains(savedLecture.getDay().getValue())) {
                if (savedLecture.getPeriod().equals(lecture.getPeriod())) {
                    throw new IllegalArgumentException("이미 수강신청한 과목과 수강시간이 겹칩니다.");
                }
            }
        }

        return true;
    }

    public boolean deleteLecture(Lecture lecture) {
        this.lectures.remove(lecture);
        return true;
    }

}
