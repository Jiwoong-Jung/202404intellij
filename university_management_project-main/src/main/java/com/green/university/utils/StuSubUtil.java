package com.green.university.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.green.university.dto.response.StuSubDayTimeDto;
import com.green.university.dto.response.StuSubSumGradesDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.Subject;

/**
 * @author 서영
 * 예비 수강신청 관련 유틸
 */
public class StuSubUtil {

	// 최대 수강 가능 학점을 넘지 않는지 확인
	public static void checkSumGrades(Subject targetSubject, StuSubSumGradesDto stuSubSumGradesDto) {
		// 신청 내역이 있다면
		if (stuSubSumGradesDto != null) {
			int sumGrades = stuSubSumGradesDto.getSumGrades();
			
			// 신청하려는 강의의 학점
			int subGrades = targetSubject.getGrades();
			
			// 현재 학점 + 신청 강의 학점이 최대 수강 가능 학점을 초과한다면
			if ((sumGrades + subGrades) > Define.MAX_GRADES) {
				throw new CustomRestfullException("신청 가능한 최대 학점을 초과했습니다.", HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	// 신청하려는 강의와 현재 학생의 시간표가 겹치지 않는지 확인
	public static void checkDayTime(Subject targetSubject, List<StuSubDayTimeDto> dayTimeList) {
		
		// 예비 수강 신청 내역은 연도/학기를 체크하지 않아도 됨 (연도/학기별로 초기화시키므로)
		// start_time ~ end_time을 정수형 배열로 생성해서 contains로 확인하기 ?
		
		// 신청 대상 과목의 시간 배열
		List<Integer> targetTimeList = new ArrayList<>();
		for (int i = targetSubject.getStartTime(); i <= targetSubject.getEndTime(); i++) {
			targetTimeList.add(i);
		}

		// 신청 내역 시간표를 돌면서, 신청 대상 과목의 요일과 겹치는지 확인
		
		List<Integer> checkDayList = new ArrayList<>();
		
		for (int i = 0; i < dayTimeList.size(); i++) {
			if (dayTimeList.get(i).getSubDay().equals(targetSubject.getSubDay())) {
				checkDayList.add(1);
				// 1이면 체크 대상
			} else {
				checkDayList.add(0);
			}
		}
		
		for (int i = 0; i < checkDayList.size(); i++) {
			
			// 요일이 겹쳐서 시간을 체크해야 함
			// i번째 값이 1이라면, dayTimeList에서 i번째 신청내역과목을 체크함
			if (checkDayList.get(i) == 1) {
				// 시작시간과 끝시간이 동일하다면 체크 X
				if (dayTimeList.get(i).getStartTime().intValue() == targetSubject.getEndTime().intValue()
					|| dayTimeList.get(i).getEndTime().intValue() == targetSubject.getStartTime().intValue()) {
					continue;
				}
				
				for (Integer j : targetTimeList) {
					if (dayTimeList.get(i).timeList().contains(j)) {
						throw new CustomRestfullException("이전에 신청한 강의와 시간이 중복됩니다.", HttpStatus.BAD_REQUEST);
					}
				}
			}
		}
	}
	
	
	
}
