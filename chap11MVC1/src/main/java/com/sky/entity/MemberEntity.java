package com.sky.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime regdate;

}
