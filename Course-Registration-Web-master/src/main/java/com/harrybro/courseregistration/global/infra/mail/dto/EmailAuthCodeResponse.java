package com.harrybro.courseregistration.global.infra.mail.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthCodeResponse {

    private String email;
    private String message;

}