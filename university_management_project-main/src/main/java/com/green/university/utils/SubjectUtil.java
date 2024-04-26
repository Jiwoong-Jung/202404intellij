package com.green.university.utils;

import java.util.List;

import com.green.university.dto.SubjectFormDto;
import com.green.university.repository.model.Subject;
import com.green.university.service.AdminService;

/**
 * 
 * @author 성희 강의 입력 관련 유틸
 *
 */
public class SubjectUtil {

	public boolean calculate(SubjectFormDto subjectFormDto, List<Subject> subjectList) {
		for (int i = 0; i < subjectList.size(); i++) {
			if ((subjectList.get(i).getStartTime() <= subjectFormDto.getStartTime()
					&& subjectFormDto.getStartTime() < subjectList.get(i).getEndTime())
					|| (subjectList.get(i).getStartTime() < subjectFormDto.getEndTime()
							&& subjectFormDto.getEndTime() <= subjectList.get(i).getEndTime())) {
				return false;
			}
		}
		return true;
	}
}
