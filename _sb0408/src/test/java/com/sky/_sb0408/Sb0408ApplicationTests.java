package com.sky._sb0408;

import com.sky._sb0408.spring.Member;
import com.sky._sb0408.spring.MemberListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb0408ApplicationTests {

    @Autowired
    MemberListService memberListService;

    @Test
    void contextLoads() {
        for (Member member : memberListService.getMemberList()) {
            System.out.println(member);
        }
    }

}
