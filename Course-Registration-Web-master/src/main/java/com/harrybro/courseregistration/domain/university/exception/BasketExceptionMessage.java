package com.harrybro.courseregistration.domain.university.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BasketExceptionMessage {
    ALREADY_IN_BASKET_EXCEPTION_MESSAGE("이미 장바구니에 담긴 강의입니다.");

    private final String message;
}
