package com.harrybro.courseregistration.domain.university.dto;

import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.domain.university.domain.Lecture;
import lombok.*;

import java.time.LocalTime;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnrollmentSaveResponse {

    private Long id;
    private String name;
    private String lecturer;
    private int credit;
    private String major;
    private String day;
    private LocalTime startTime;
    private LocalTime endTime;
    private int leftCredit;

    public static EnrollmentSaveResponse of(User user, Lecture lecture) {
        return EnrollmentSaveResponse.builder()
                .id(lecture.getId())
                .name(lecture.getName())
                .lecturer(lecture.getLecturer())
                .credit(lecture.getCredit())
                .major(lecture.getMajor().getName())
                .day(lecture.getDay().getValue())
                .startTime(lecture.getPeriod().getStartTime())
                .endTime(lecture.getPeriod().getEndTime())
                .leftCredit(user.getCredit())
                .build();
    }

}
