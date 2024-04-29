package com.example.springedu;

import com.example.springedu.entity.Meeting;
import com.example.springedu.entity.Reply;
import com.example.springedu.repository.MeetingRepository;
import com.example.springedu.repository.ReplyRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MeetingReplyTest {
    @Autowired
    private MeetingRepository repo1;
    @Autowired
    private ReplyRepository repo2;
    
    @BeforeEach()
    void pr() {
        System.out.println("=".repeat(80));
    }
   @Test
    void test1() {
    	List<Meeting> list = repo1.findAll();
        list.stream().forEach(System.out::println);
    }
    @Test
    void test2() {
        List<Reply> list = repo2.findAll();
        list.stream().forEach(System.out::println);
    }
    @AfterAll
    static void end() {
        System.out.println("=".repeat(80));
        System.out.println("[[[[[[ 테스트 종료 ]]]]]]");
    }
}
