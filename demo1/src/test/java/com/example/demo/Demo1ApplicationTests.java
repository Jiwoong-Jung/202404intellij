package com.example.demo;

import com.example.demo.dao.Member;
import com.example.demo.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Demo1ApplicationTests {

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
