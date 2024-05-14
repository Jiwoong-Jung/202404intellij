package com.harrybro.courseregistration.domain.university.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@AllArgsConstructor
@Getter
public enum LecturePeriod {

    ZERO_PERIOD(LocalTime.of(8, 0), LocalTime.of(8, 50)),
    ONE_PERIOD(LocalTime.of(9, 0), LocalTime.of(9, 50)),
    TWO_PERIOD(LocalTime.of(10, 0), LocalTime.of(10, 50)),
    THREE_PERIOD(LocalTime.of(11, 0), LocalTime.of(11, 50)),
    FOUR_PERIOD(LocalTime.of(12, 0), LocalTime.of(12, 50)),
    FIVE_PERIOD(LocalTime.of(13, 0), LocalTime.of(13, 50)),
    SIX_PERIOD(LocalTime.of(14, 0), LocalTime.of(14, 50)),
    SEVEN_PERIOD(LocalTime.of(15, 0), LocalTime.of(15, 50)),
    EIGHT_PERIOD(LocalTime.of(16, 0), LocalTime.of(16, 50)),
    NINE_PERIOD(LocalTime.of(17, 0), LocalTime.of(17, 50)),
    TEN_PERIOD(LocalTime.of(18, 0), LocalTime.of(18, 50)),
    ELEVEN_PERIOD(LocalTime.of(19, 0), LocalTime.of(19, 50)),
    TWELVE_PERIOD(LocalTime.of(20, 0), LocalTime.of(20, 50));

    private LocalTime startTime;
    private LocalTime endTime;

}
