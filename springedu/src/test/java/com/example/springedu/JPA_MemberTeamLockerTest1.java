package com.example.springedu;

import com.example.springedu.entity.Member;
import com.example.springedu.repository.MemberTeamLockerRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MemberTeamLockerTest1 {
    @Autowired
    private MemberTeamLockerRepository repo;
    
    @BeforeEach
    void pr() {
    	System.out.println("=".repeat(80));
    }
    @Test
    void test_aaa1() {
        System.out.println("[[[ test_aaa1() 수행 ]]]");
    	List<Member> list = repo.aaa1("겨울왕국");
    	list.stream().forEach(System.out::println);
    }
    @Test
    void test_aaa2() {
        System.out.println("[[[ test_aaa2() 수행 ]]]");
        List<Member> list = repo.aaa2("겨울왕국");
        list.stream().forEach(System.out::println);
    }
    @Test
    void test_findByTeamName() {
        System.out.println("[[[ test_findByTeamName() 수행 ]]]");
        List<Member> list = repo.findByTeamName("겨울왕국");
        list.stream().forEach(System.out::println);
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
