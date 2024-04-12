package com.sky._sb0409;

import com.sky._sb0409.entity.Member;
import com.sky._sb0409.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Sb0409Application {

    @Autowired
    MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(Sb0409Application.class, args);
    }

    @PostConstruct
    public void init() {
        IntStream.rangeClosed(1, 10).forEach(i->{
            Member member = new Member("test"+i+"@korea.com", 1000+i+"", "홍길동"+i, LocalDateTime.now());
            memberRepository.save(member);
        });
    }

}
