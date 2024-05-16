package com.sky.mybatisdynamic;

import com.sky.mybatisdynamic.dao.Member;
import com.sky.mybatisdynamic.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MybatisDynamicApplicationTests {

    @Autowired
    MemberMapper memberMapper;

    @Test
    void contextLoads() {
        Member member = Member.builder().email("jjj@test.com").password("1234").name("주하나").regdate(new Date()).build();
        System.out.println(memberMapper.insert(member));
    }

    @Test
    void display() {
        System.out.println(memberMapper.selectByPrimaryKey(75));
    }

}
