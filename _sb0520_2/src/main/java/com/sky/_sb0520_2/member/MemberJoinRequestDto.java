package com.sky._sb0520_2.member;

import lombok.Builder;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class MemberJoinRequestDto {


    private String username;

    private String password;

    @Builder
    public MemberJoinRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.USER)
//                .role(Role.ADMIN)
                .build();
    }
}
