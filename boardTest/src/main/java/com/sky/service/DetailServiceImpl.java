package com.sky.service;

import com.sky.entity.Notice;
import com.sky.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final NoticeRepository noticeRepository;
    @Override
    public Notice detail(Long seq) {
        Notice notice = noticeRepository
                .findById(seq).orElseThrow();
        return notice;
    }
}
