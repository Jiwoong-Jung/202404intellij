package com.sky._sb0419;

import com.sky._sb0419.entity.Notice;
import com.sky._sb0419.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class Sb0419ApplicationTests {

    @Autowired
    NoticeRepository noticeRepository;

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 100).forEach(i->{
            Notice notice = Notice.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .build();
            noticeRepository.save(notice);
        });
        System.out.println("---------------------");
        System.out.println(noticeRepository.selectCount());
        System.out.println("---------------------");
    }

}
