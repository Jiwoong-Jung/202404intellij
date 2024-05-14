package com.harrybro.courseregistration.domain.university.exception;

public class AlreadyInBasketException extends IllegalArgumentException {
    public AlreadyInBasketException(BasketExceptionMessage e) {
        super(e.getMessage());
    }
}
