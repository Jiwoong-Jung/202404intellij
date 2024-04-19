package com.sky.service;


import com.sky.entity.Notice;
import com.sky.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeRepository noticeRepository;
    @Override
    public Notice saveNotice(Notice notice) {
//        Notice notice1 = noticeRepository.save(notice);
        noticeRepository.insertNotice(notice);
        return notice;
    }
}
