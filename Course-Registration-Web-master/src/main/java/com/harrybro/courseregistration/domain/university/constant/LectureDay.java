package com.harrybro.courseregistration.domain.university.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LectureDay {

    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    MONDAY_AND_WEDNESDAY("월,수"),
    TUESDAY_AND_THURSDAY("화,목");


    private String value;

}
