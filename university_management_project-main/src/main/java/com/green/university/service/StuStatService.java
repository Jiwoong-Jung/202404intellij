package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.StuStatRepository;
import com.green.university.repository.interfaces.StudentRepository;
import com.green.university.repository.model.StuStat;

/**
 * @author 서영
 *
 */
@Service
public class StuStatService {

	@Autowired
	private StuStatRepository stuStatRepository;

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * @param studentId
	 * @return 해당 학생의 현재 학적 상태 (.getStatus())
	 */
	@Transactional
	public StuStat readCurrentStatus(Integer studentId) {

		StuStat stuStatEntity = stuStatRepository.selectByStudentIdOrderbyIdDesc(studentId).get(0);

		return stuStatEntity;
	}

	/**
	 * @param studentId
	 * @return 해당 학생의 전체 학적 변동 내역 조회
	 */
	@Transactional
	public List<StuStat> readStatusList(Integer studentId) {

		List<StuStat> stuStatList = stuStatRepository.selectByStudentIdOrderbyIdDesc(studentId);

		return stuStatList;
	}

	/**
	 * 모든 학생 id 리스트
	 */
	public List<Integer> readIdList() {

		List<Integer> idList = studentRepository.selectIdList();

		return idList;
	}

	/*
	 * 처음 학생이 생성될 때 학적 상태 지정 (재학)
	 *
	 * 첫 학적 상태 저장과 이후 변동 사항을 저장할 때의 메서드를 분리한 이유는 이후 변동 사항을 지정할 때에는 기존의 상태 데이터의
	 * toDate를 현재 날짜로 바꿔주는 작업이 추가로 필요하기 때문임
	 */
	@Transactional
	public void createFirstStatus(Integer studentId) {

		int resultRowCount = stuStatRepository.insert(studentId, "재학", "9999-01-01", null);

		if (resultRowCount != 1) {
			throw new CustomRestfullException("학적 상태 생성에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * 학적 상태 변동 새로운 상태 추가 + 기존 학적 상태의 to_date를 now()로 변경 breakAppId가 없다면 null로 받기
	 */

	public void updateStatus(Integer studentId, String newStatus, String newToDate, Integer breakAppId) {

		// 가장 최근의 기존 학적 상태 데이터의 id
		Integer targetId = stuStatRepository.selectByStudentIdOrderbyIdDesc(studentId).get(0).getId();

		// 기존 학적 상태의 to_date를 now()로 변경
		int updateRowCount = stuStatRepository.updateOldStatus(targetId);

		// 새로운 학적 상태 추가
		int insertRowCount = stuStatRepository.insert(studentId, newStatus, newToDate, breakAppId);

		if (updateRowCount != 1 || insertRowCount != 1) {
			throw new CustomRestfullException("학적 상태 변경에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
