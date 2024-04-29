package com.example.springedu;

import com.example.springedu.entity.Reply;
import com.example.springedu.repository.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class JPA_MeetingReplyTest2 {
    @Autowired
    private ReplyRepository repo;

    @Test
    void test1() {
    	List<Reply> list = repo.findAllJoinFetch();
        list.stream().forEach(System.out::println);
    }
}
