package com.harrybro.courseregistration.domain.university.dto;

import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserAndLectureDto {

    private User user;
    private Lecture lecture;

    public static UserAndLectureDto of(User user, Lecture lecture) {
        return new UserAndLectureDto(user, lecture);
    }

}
