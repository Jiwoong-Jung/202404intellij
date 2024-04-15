package com.sky._sb0411.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> dataList;
    private int age;
    private String name;

    @Builder
    public Answer(List<String> dataList, int age, String name) {
        this.dataList = dataList;
        this.age = age;
        this.name = name;
    }

    public static Answer toEntity(com.sky._sb0411.problem.Answer dto) {
        return Answer.builder()
                .dataList(dto.getDataList())
                .age(dto.getAge())
                .name(dto.getName())
                .build();
    }
}
