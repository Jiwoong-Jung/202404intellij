package com.sky;

import com.sky.entity.MemberEntity;
import com.sky.repository.MemberRepository;
import com.sky.spring.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class Chap11Mvc1Application {

    @Autowired
    MemberRepository memberRepository;

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
    }
}
