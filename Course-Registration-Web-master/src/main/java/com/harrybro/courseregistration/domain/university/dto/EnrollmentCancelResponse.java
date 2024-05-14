package com.harrybro.courseregistration.domain.university.dto;

import com.harrybro.courseregistration.domain.user.domain.User;
import lombok.*;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EnrollmentCancelResponse {

    private final int leftCredit;

    public static EnrollmentCancelResponse from(User user) {
        return EnrollmentCancelResponse.builder().leftCredit(user.getCredit()).build();
    }

}
