package com.sky;

import com.sky.entity.Notice;
import com.sky.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class BoardTestApplication {

    private final NoticeRepository noticeRepository;

    public static void main(String[] args) {
        SpringApplication.run(BoardTestApplication.class, args);
    }
    @PostConstruct
    public void init() {
        Notice notice = Notice.builder()
                .title("제목3").content("내용3").build();
//        noticeRepository.saveAndFlush(notice);
        noticeRepository.insertNotice(notice);
    }
}
