package com.harrybro.courseregistration.domain.user.exception;

public class LackOfCreditException extends IllegalArgumentException {
    public LackOfCreditException(UserExceptionMessage e) {
        super(e.getMessage());
    }
}
