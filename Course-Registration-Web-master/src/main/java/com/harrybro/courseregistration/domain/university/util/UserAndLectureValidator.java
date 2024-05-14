package com.harrybro.courseregistration.domain.university.util;

import com.harrybro.courseregistration.domain.university.dto.UserAndLectureDto;
import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.domain.user.repository.UserRepository;
import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.university.repository.LectureRepository;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserAndLectureValidator {

    private final UserRepository userRepository;
    private final LectureRepository lectureRepository;

    public  UserAndLectureDto validate(PrincipalDetail principal, Long lectureId) {
        User user = userRepository.findByEmail(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("해당 유저가 존재하지 않습니다."));
        Lecture lecture = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다."));
        return UserAndLectureDto.of(user, lecture);
    }

}
