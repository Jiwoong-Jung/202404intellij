package com.sky.spring;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;


    @Builder
    public Member(String email, String password, String name, LocalDateTime regdate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regdate = regdate;
    }

    void setId(Long id) {
        this.id = id;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword))
            throw new WrongIdPasswordException();
        this.password = newPassword;
    }
}
