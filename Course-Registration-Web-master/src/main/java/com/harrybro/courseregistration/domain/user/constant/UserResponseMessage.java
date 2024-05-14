package com.harrybro.courseregistration.domain.user.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserResponseMessage {

    SiGN_UP_SUCCESS("해당 메일 주소로 이메일 인증 메일을 발송했습니다. 메일 인증을 하시면 회원가입이 완료됩니다.");

    private final String message;

}
