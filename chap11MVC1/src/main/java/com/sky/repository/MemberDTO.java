package com.sky.repository;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDTO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;
}
