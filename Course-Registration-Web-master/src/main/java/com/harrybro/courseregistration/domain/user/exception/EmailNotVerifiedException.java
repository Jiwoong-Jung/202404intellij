package com.harrybro.courseregistration.domain.user.exception;

public class EmailNotVerifiedException extends IllegalArgumentException {

    public EmailNotVerifiedException(UserExceptionMessage m) {
        super(m.getMessage());
    }

}
