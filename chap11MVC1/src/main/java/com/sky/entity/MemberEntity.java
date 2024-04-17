package com.sky.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;

    @Builder
    public MemberEntity(String email, String password, String name, LocalDateTime regdate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regdate = regdate;
    }
}
