package com.example.springedu;

import com.example.springedu.repository.MemberTeamLockerRepository;
import com.example.springedu.repository.TeamName;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MemberTeamLockerTest2 {
    @Autowired
    private MemberTeamLockerRepository repo;
    
    @BeforeEach
    void pr() {
    	System.out.println("=".repeat(80));
    }
    @Test
    void test_bbb1() {
        System.out.println("[[[ test_bbb1() 수행 ]]]");
        String teamName = repo.bbb1("둘리");
        System.out.println(teamName);
    }
    @Test
    void test_bbb2() {
        System.out.println("[[[ test_bbb2() 수행 ]]]");
        String teamName = repo.bbb2("둘리");
        System.out.println(teamName);
    }
    @Test
    void test_findByTeamName() {
        System.out.println("[[[ test_findByTeamName() 수행 ]]]");
        TeamName result = repo.getByUsername("둘리");
        System.out.println(result.getTeamName());
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
