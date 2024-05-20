package com.sky._sb0520_2.member;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Entity
public class Member{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public Member(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;

    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
