package com.harrybro.courseregistration.domain.university.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasketResponseMessage {

    SAVE_SUCCESS_TO_BASKET("선택한 과목이 장바구니에 저장되었습니다."),
    DELETE_SUCCESS_TO_BASKET("선택한 과목이 장바구니에서 삭제되었습니다.");

    private final String message;
}
