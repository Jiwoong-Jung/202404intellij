package com.harrybro.courseregistration.domain.university.service;

import com.harrybro.courseregistration.domain.university.constant.BasketResponseMessage;
import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.university.dto.UserAndLectureDto;
import com.harrybro.courseregistration.domain.university.exception.AlreadyInBasketException;
import com.harrybro.courseregistration.domain.university.exception.BasketExceptionMessage;
import com.harrybro.courseregistration.domain.university.util.UserAndLectureValidator;
import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import com.harrybro.courseregistration.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BasketService {

    private final UserAndLectureValidator userAndLectureValidator;

    @Transactional
    public ResponseDto<?> saveLecture(Long lectureID, PrincipalDetail principal) {
        UserAndLectureDto validate = userAndLectureValidator.validate(principal, lectureID);
        User user = validate.getUser();
        Lecture lecture = validate.getLecture();
        if (user.getBasket().getLectures().stream().anyMatch(l -> l.equals(lecture)))
            throw new AlreadyInBasketException(BasketExceptionMessage.ALREADY_IN_BASKET_EXCEPTION_MESSAGE);
        user.getBasket().saveLecture(lecture);
        return ResponseDto.from(BasketResponseMessage.SAVE_SUCCESS_TO_BASKET.getMessage());
    }

    @Transactional
    public ResponseDto<?> deleteLecture(Long lectureID, PrincipalDetail principal) {
        UserAndLectureDto validate = userAndLectureValidator.validate(principal, lectureID);
        User user = validate.getUser();
        Lecture lecture = validate.getLecture();
        user.getBasket().deleteLecture(lecture);
        return ResponseDto.from(BasketResponseMessage.DELETE_SUCCESS_TO_BASKET.getMessage());
    }

}
