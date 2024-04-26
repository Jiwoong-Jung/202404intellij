package com.green.university.utils;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.BreakApp;
import com.green.university.repository.model.StuStat;

public class StuStatUtil {

	// 이번 학기 재학 상태인지 확인
	public static void checkStuStat(String type, StuStat stuStatEntity, List<BreakApp> breakAppList) {
		
		// 해당 학생의 학적 상태가 '졸업' 또는 '자퇴'라면
		if (stuStatEntity.getStatus().equals("졸업") || stuStatEntity.getStatus().equals("자퇴")) {
			System.out.println("졸업 또는 자퇴한 학생입니다.");
			if (type.equals("등록금")) {
				throw new CustomRestfullException("등록금 납부 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
			} else if (type.equals("수강신청")) {
				throw new CustomRestfullException("수강 신청 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
			}
		}
		
		// 해당 학생이 현재 학기 휴학을 승인받은 상태라면
		for (BreakApp b : breakAppList) {
			// 휴학 신청이 승인된 상태일 때
			if (b.getStatus().equals("승인")) {
				// 휴학 종료 연도가 현재 연도보다 이후라면 생성하지 않음
				if (b.getToYear() > Define.CURRENT_YEAR) {
					if (type.equals("등록금")) {
						throw new CustomRestfullException("등록금 납부 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
					} else if (type.equals("수강신청")) {
						throw new CustomRestfullException("수강 신청 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
					}
				// 휴학 종료 연도가 현재 연도와 같을 경우
				} else if (b.getToYear() == Define.CURRENT_YEAR) {
					if (b.getToSemester() >= Define.CURRENT_SEMESTER) {
						if (type.equals("등록금")) {
							throw new CustomRestfullException("등록금 납부 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
						} else if (type.equals("수강신청")) {
							throw new CustomRestfullException("수강 신청 대상이 아닙니다.", HttpStatus.BAD_REQUEST);
						}
					}
				}
			}
		}
		
	}
	
	
}
