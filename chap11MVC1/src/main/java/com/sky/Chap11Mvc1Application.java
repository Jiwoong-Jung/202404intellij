package com.sky;

import com.sky.entity.MemberEntity;
import com.sky.entity.QuestionEntity;
import com.sky.repository.MemberRepository;
import com.sky.repository.QuestionRepository;
import com.sky.spring.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class Chap11Mvc1Application {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(Chap11Mvc1Application.class, args);
    }

    @PostConstruct
    private void init() {
        MemberEntity member = MemberEntity.builder()
                .email("admin@korea.com")
                .name("강하나")
                .password("1234")
                .regdate(LocalDateTime.now())
                .build();
        memberRepository.save(member);
        QuestionEntity q1 = new QuestionEntity("당신의 역할은 무엇입니까?",
                Arrays.asList("백엔드", "프론트", "DBA", "웹디자인"));
        questionRepository.save(q1);

        QuestionEntity q2 = new QuestionEntity("많이 사용하는 개발도구는 무엇입니까?",
                Arrays.asList("이클립스", "인텔리J", "서브라임"));
        questionRepository.save(q2);
        QuestionEntity q3 = new QuestionEntity("하고 싶은 말은?");
        questionRepository.save(q3);
    }
}
