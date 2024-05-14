package com.harrybro.courseregistration.global.infra.mail.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EmailSubject {

    EMAIL_AUTH_REQUEST("[명지대학교] 회원가입 인증 메일"),
    FIND_PASSWORD_REQUEST("[명지대학교] 임시 비밀번호 안내 메일"),
    FIND_EMAIL_REQUEST("[명지대학교] 이메일 찾기 안내 메일");

    @Getter
    private final String subject;

}
