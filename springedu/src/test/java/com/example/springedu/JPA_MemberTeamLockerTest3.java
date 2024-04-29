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
public class JPA_MemberTeamLockerTest3 {
    @Autowired
    private MemberTeamLockerRepository repo;
    
    @BeforeEach
    void pr() {
        System.out.println("=".repeat(80));
    }
    @Test
    void test_findAll1() {
        List<Member> list = repo.findAll();
        list.stream().forEach(System.out::println);
    }
    @Test
    void test_findAll2() {
        List<Member> list = repo.findAll();
        for(Member m : list) {
            System.out.print(m.getUsername()+", ");
            System.out.print(m.getTeam() != null ? m.getTeam().getName()+", ": "없음, ");
            System.out.println(m.getLocker() != null ? m.getLocker().getName() : "없음");
        }
    }
    @Test
    void test_findByLockerName() {
        Member member = repo.getByLockerName("B101");
        System.out.printf("B101 락커를 사용하는 회원은 %s팀 소속의 %s입니다\n", member.getTeam().getName(), member.getUsername());
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
