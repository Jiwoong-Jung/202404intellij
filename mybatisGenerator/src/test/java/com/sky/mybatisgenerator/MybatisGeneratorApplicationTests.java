package com.sky.mybatisgenerator;

import com.sky.mybatisgenerator.dao.Member;
import com.sky.mybatisgenerator.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisGeneratorApplicationTests {

    @Autowired
    MemberMapper memberMapper;

    @Test
    void contextLoads() {
        Member member = Member.builder().email("rrr@test.com").password("1234").name("강하다").build();
        System.out.println(memberMapper.insert(member));
    }

    @Test
    void display() {
        System.out.println(memberMapper.selectByPrimaryKey(75));
    }

}
