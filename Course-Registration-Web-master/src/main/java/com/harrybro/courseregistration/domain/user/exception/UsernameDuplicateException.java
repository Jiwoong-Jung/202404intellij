package com.harrybro.courseregistration.domain.user.exception;

public class UsernameDuplicateException extends IllegalArgumentException {

    public UsernameDuplicateException(String username) {
        super(username + "은 이미 존재하는 아이디입니다.");
    }
}
