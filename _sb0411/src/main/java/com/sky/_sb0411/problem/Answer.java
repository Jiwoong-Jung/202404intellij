package com.sky._sb0411.problem;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@ToString
public class Answer {

    private List<String> dataList;
    private int age;
    private String name;
}
