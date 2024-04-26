package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.green.university.dto.CollTuitFormDto;
import com.green.university.dto.CollegeFormDto;
import com.green.university.dto.DepartmentFormDto;
import com.green.university.dto.RoomFormDto;
import com.green.university.dto.SubjectFormDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.interfaces.CollTuitRepository;
import com.green.university.repository.interfaces.CollegeRepository;
import com.green.university.repository.interfaces.DepartmentRepository;
import com.green.university.repository.interfaces.RoomRepository;
import com.green.university.repository.interfaces.SubjectRepository;
import com.green.university.repository.interfaces.SyllaBusRepository;
import com.green.university.repository.model.College;
import com.green.university.repository.model.Department;
import com.green.university.repository.model.Room;
import com.green.university.repository.model.Subject;
import com.green.university.utils.SubjectUtil;

/**
 * 
 * @author 박성희
 *
 */

@Service
public class AdminService {
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private CollTuitRepository collTuitRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SyllaBusRepository syllaBusRepository;

	/**
	 * 단과대 입력 서비스
	 */
	@Transactional
	public void createCollege(@Validated CollegeFormDto collegeFormDto) {
		// 같은 이름 중복 검사
		List<College> collegeList = collegeRepository.selectCollegeDto();
		for (int i = 0; i < collegeList.size(); i++) {
			if (collegeList.get(i).getName().equals(collegeFormDto.getName())) {
				throw new CustomRestfullException("이미 존재하는 단과대입니다", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		int resultRowCount = collegeRepository.insert(collegeFormDto);
		if (resultRowCount != 1) {
			System.out.println("단과대 입력 서비스 오류");
		}
	}

	/**
	 * 단과대 조회 서비스
	 */
	@Transactional
	public List<College> readCollege() {
		List<College> collegeList = collegeRepository.selectCollegeDto();
		return collegeList;
	}

	/**
	 * 단과대 삭제 서비스
	 */
	public int deleteCollege(Integer id) {
		int resultRowCount = collegeRepository.deleteById(id);
		return resultRowCount;
	}

	/**
	 * 학과 입력 서비스
	 */
	@Transactional
	public void createDepartment(@Validated DepartmentFormDto departmentFormDto) {
		// 같은 학과 이름 중복 검사
		List<Department> departmentList = departmentRepository.selectByDepartmentDto();
		for (int i = 0; i < departmentList.size(); i++) {
			if (departmentList.get(i).getName().equals(departmentFormDto.getName())) {
				throw new CustomRestfullException("이미 존재하는 학과입니다", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		int resultRowCount = departmentRepository.insert(departmentFormDto);
		if (resultRowCount != 1) {
			System.out.println("학과 입력 서비스 오류");
		}
	}

	/**
	 * 학과 조회 서비스
	 */
	public List<Department> readDepartment() {
		List<Department> departmentList = departmentRepository.selectByDepartmentDto();
		for (int i = 0; i < departmentList.size(); i++) {
			System.out.println(departmentList.get(i));
		}
		return departmentList;
	}

	/**
	 * 학과 삭제 서비스
	 */
	public int deleteDepartment(Integer collegeId) {
		int resultRowCount = departmentRepository.deleteById(collegeId);
		return resultRowCount;
	}

	/**
	 * 학과 수정 서비스
	 */
	public int updateDepartment(DepartmentFormDto departmentFormDto) {
		int resultRowCount = departmentRepository.updateByDepartmentDto(departmentFormDto);
		if (resultRowCount != 1) {
			System.out.println("학과 수정 서비스 오류");
		}
		return resultRowCount;
	}

	/**
	 * 단과대별 등록금 입력 서비스
	 */
	@Transactional
	public void createCollTuit(@Validated CollTuitFormDto collTuitFormDto) {
		// 등록금 중복 입력 검사
		List<CollTuitFormDto> collTuitList = collTuitRepository.selectByCollTuitDto();
		for (int i = 0; i < collTuitList.size(); i++) {
			if (collTuitList.get(i).getCollegeId() == (collTuitFormDto.getCollegeId())) {
				throw new CustomRestfullException("이미 등록금이 입력된 학과입니다", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		int resultRowCount = collTuitRepository.insert(collTuitFormDto);
		if (resultRowCount != 1) {
			System.out.println("단과대 등록금 입력 서비스 오류");
		}
	}

	/**
	 * 단과대 등록금 조회 서비스
	 */
	public List<CollTuitFormDto> readCollTuit() {
		List<CollTuitFormDto> collTuitList = collTuitRepository.selectByCollTuitDto();
		return collTuitList;
	}

	/**
	 * 단과대 등록금 삭제 서비스
	 */
	public int deleteCollTuit(Integer collegeId) {
		int resultRowCount = collTuitRepository.deleteById(collegeId);
		return resultRowCount;
	}

	/**
	 * 단과대 등록금 수정 서비스
	 */
	public int updateCollTuit(CollTuitFormDto collTuitFormDto) {
		int resultRowCount = collTuitRepository.updateByCollTuitDto(collTuitFormDto);
		if (resultRowCount != 1) {
			System.out.println("단과대 등록금 수정 서비스 오류");
		}
		return resultRowCount;
	}

	/**
	 * 강의실 입력 서비스
	 */
	@Transactional
	public void createRoom(@Validated RoomFormDto roomFormDto) {
		// 강의실 중복 입력 검사
		List<Room> roomList = roomRepository.selectByRoomDto();
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getId().equals((roomFormDto.getId()))) {
				throw new CustomRestfullException("이미 존재하는 강의실입니다", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		int resultRowCount = roomRepository.insert(roomFormDto);
		if (resultRowCount != 1) {
			System.out.println("강의실 입력 서비스 오류");
		}
	}

	/**
	 * 강의실 조회 서비스
	 */
	public List<Room> readRoom() {
		List<Room> roomList = roomRepository.selectByRoomDto();
		return roomList;
	}

	/**
	 * 강의실 삭제 서비스
	 */
	public int deleteRoom(String id) {
		int resultRowCount = roomRepository.deleteById(id);
		return resultRowCount;
	}

	/**
	 * 강의 입력 서비스
	 */
	@Transactional
	public List<Subject> createSubjectAndSyllabus(@Validated SubjectFormDto subjectFormDto) {
		// 강의실, 강의시간 중복 검사
		List<Subject> subjectList = subjectRepository.selectByRoomIdAndSubDayAndSubYearAndSemester(subjectFormDto);
		if (subjectList != null) {
			SubjectUtil subjectUtil = new SubjectUtil();
			boolean result = subjectUtil.calculate(subjectFormDto, subjectList);
			if (result == false) {
				throw new CustomRestfullException("해당 시간대는 강의실을 사용중입니다! 다시 선택해주세요", HttpStatus.BAD_REQUEST);
			}
		}
		subjectRepository.insert(subjectFormDto);

		// 강의계획서에 강의 ID 저장
		Integer subjectId = subjectRepository.selectIdOrderById(subjectFormDto);
		syllaBusRepository.insertOnlySubId(subjectId);
		return subjectList;
	}

	/**
	 * 강의 조회 서비스
	 */
	public List<Subject> readSubject() {
		List<Subject> subjectList = subjectRepository.selectAll();
		return subjectList;
	}

	/**
	 * 강의 삭제 서비스
	 */
	public int deleteSubject(Integer id) {
		int resultRowCount = subjectRepository.deleteById(id);
		syllaBusRepository.delete(id);
		return resultRowCount;
	}

	/**
	 * 강의 수정 서비스
	 */
	public int updateSubject(SubjectFormDto subjectFormDto) {
		// ID로 연도 학기 조회
		Subject subject = subjectRepository.selectSubjectById(subjectFormDto.getId());
		subjectFormDto.setSubYear(subject.getSubYear());
		subjectFormDto.setSemester(subject.getSemester());
		// 강의실, 강의시간 중복 검사
		List<Subject> subjectList = subjectRepository.selectByRoomIdAndSubDayAndSubYearAndSemester(subjectFormDto);
		if (subjectList != null) {
			SubjectUtil subjectUtil = new SubjectUtil();
			boolean result = subjectUtil.calculate(subjectFormDto, subjectList);
			if (result == false) {
				throw new CustomRestfullException("해당 시간대는 강의실을 사용중입니다! 다시 선택해주세요", HttpStatus.BAD_REQUEST);
			}
		}
		int resultRowCount = subjectRepository.updateBySubjectDto(subjectFormDto);
		if (resultRowCount != 1) {
			System.out.println("강의 수정 서비스 오류");
		}
		return resultRowCount;
	}

}
