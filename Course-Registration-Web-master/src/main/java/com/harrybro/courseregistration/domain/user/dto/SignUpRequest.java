package com.harrybro.courseregistration.domain.user.dto;

import com.harrybro.courseregistration.domain.university.domain.Basket;
import com.harrybro.courseregistration.domain.university.domain.Enrollment;
import com.harrybro.courseregistration.domain.user.domain.RoleType;
import com.harrybro.courseregistration.domain.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class SignUpRequest {

    @NotBlank(message = "이메일은 공백일 수 없습니다.")
    @Email(message = "email 형식에 맞춰 입력해주세요.")
    private String email;

    @Length(min = 6, max = 25, message = "비밀번호는 최소 {min}자리 최대 {max}자 이어야 합니다.")
    private String password;

    public User toEntity(PasswordEncoder passwordEncoder, Basket basket, Enrollment enrollment) {
        return User.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .basket(basket)
                .enrollment(enrollment)
                .role(RoleType.ROLE_USER)
                .build();
    }

}
