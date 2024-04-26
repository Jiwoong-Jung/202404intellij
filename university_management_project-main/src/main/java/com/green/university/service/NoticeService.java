package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.green.university.dto.NoticeFormDto;
import com.green.university.dto.NoticePageFormDto;
import com.green.university.repository.interfaces.NoticeRepository;
import com.green.university.repository.model.Notice;

/**
 * 
 * @author 박성희 notice 관련 서비스
 *
 */

@Service
public class NoticeService {

	@Autowired
	private NoticeRepository noticeRepository;

	/**
	 * 공지 입력 서비스
	 */
	public void readNotice(@Validated NoticeFormDto noticeFormDto) {
		int resultRowCount = noticeRepository.insert(noticeFormDto);
		if (resultRowCount != 1) {
			System.out.println("공지 입력 서비스 오류");
		}
		int noticeId = noticeRepository.selectLimit(noticeFormDto);
		noticeFormDto.setNoticeId(noticeId);
		if (noticeFormDto.getOriginFilename() != null) {
			noticeRepository.insertFile(noticeFormDto);
		}
	}

	/**
	 * 공지 조회 서비스
	 */
	public List<Notice> readNotice(NoticePageFormDto noticePageFormDto) {
		List<Notice> noticeList = noticeRepository.selectByNoticeDto(noticePageFormDto);
		return noticeList;
	}

	/**
	 * 
	 * @param noticePageFormDto
	 * @return 공지 갯수 확인 서비스
	 */
	public Integer readNoticeAmount(NoticePageFormDto noticePageFormDto) {
		Integer amount = null;
		if (noticePageFormDto.getKeyword() == null) {
			amount = noticeRepository.selectNoticeCount(noticePageFormDto);
		} else {
			if ("title".equals(noticePageFormDto.getType())) {
				amount = noticeRepository.selectNoticeCountByTitle(noticePageFormDto);
			} else {
				amount = noticeRepository.selectNoticeCountByKeyword(noticePageFormDto);
			}
		}
		return amount;
	}

	/**
	 * 공지 검색 서비스
	 */
	public List<Notice> readNoticeByKeyword(NoticePageFormDto noticePageFormDto) {
		List<Notice> noticeList = null;

		if ("title".equals(noticePageFormDto.getType())) {
			noticeList = noticeRepository.selectNoticeByTitle(noticePageFormDto);
		} else {
			noticeList = noticeRepository.selectNoticeByKeyword(noticePageFormDto);
		}
		return noticeList;
	}

	/**
	 * 공지 상세 조회 서비스
	 */
	public Notice readByIdNotice(Integer id) {
		Notice notice = noticeRepository.selectById(id);
		Integer views = noticeRepository.updateViews(id);
		notice.setViews(views);
		return notice;
	}

	/**
	 * 공지 수정 서비스
	 */
	public int updateNotice(NoticeFormDto noticeFormDto) {
		int resultRowCount = noticeRepository.updateByNoticeDto(noticeFormDto);
		if (resultRowCount != 1) {
			System.out.println("공지 수정 서비스 오류");
		}
		return resultRowCount;
	}

	/**
	 * 공지 삭제 서비스
	 */
	public int deleteNotice(Integer id) {
		int resultRowCount = noticeRepository.deleteById(id);
		return resultRowCount;
	}
	
	/**
	 * 최근 글 5개 조회
	 */
	public List<NoticeFormDto> readCurrentNotice() {
		List<NoticeFormDto> noticeList = noticeRepository.selectLimit5();
		return noticeList;
	}
	
}
