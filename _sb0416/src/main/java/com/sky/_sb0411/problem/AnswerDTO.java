package com.sky._sb0411.problem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AnswerDTO {

    private Long id;
    private List<AnswerDataList> dataList;
    private int age;
    private String name;
}
