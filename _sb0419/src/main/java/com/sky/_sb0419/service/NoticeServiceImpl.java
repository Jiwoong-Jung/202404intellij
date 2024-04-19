package com.sky._sb0419.service;



import com.sky._sb0419.entity.Notice;
import com.sky._sb0419.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeRepository noticeRepository;
    @Override
    public void saveNotice(Notice notice) {
        noticeRepository.insertNotice(notice);
    }
}
