package com.sky._sb0411;

import com.sky._sb0411.entity.Question;
import com.sky._sb0411.repostory.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Sb0411Application {

    @Autowired
    QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Sb0411Application.class, args);
    }

    @PostConstruct
    public void init() {
        Question q1 = new Question("당신의 역할은 무엇입니까?",
                Arrays.asList("백엔드", "프론트", "DBA", "웹디자인"));
        questionRepository.save(q1);

        Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",
                Arrays.asList("이클립스", "인텔리J", "서브라임"));
        questionRepository.save(q2);
        Question q3 = new Question("하고 싶은 말은?");
        questionRepository.save(q3);
    }

}
