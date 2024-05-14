package com.harrybro.courseregistration.domain.user.exception;

public class EmailNotFoundException extends IllegalArgumentException {

    public EmailNotFoundException(UserExceptionMessage m) {
        super(m.getMessage());
    }

}
