package com.sky._sb0401.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String title;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Member member;

    @Builder
    public Board(String title, String content, Date createDate, Long cnt, Member member) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.cnt = cnt;
        this.member = member;
    }
}
