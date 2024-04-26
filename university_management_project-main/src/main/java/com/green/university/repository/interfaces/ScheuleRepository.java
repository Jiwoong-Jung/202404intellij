package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.ScheduleDto;
import com.green.university.dto.ScheduleFormDto;
import com.green.university.repository.model.Schedule;

@Mapper
public interface ScheuleRepository { // todo ScheduleRepository로 변경

// 기본 기능
public int insertSchoeduleFormDto(Schedule schedule);
public int updateSchoeduleFormDtoBycontent(ScheduleFormDto scheduleFormDto);
public int deleteSchoeduleFormDtoByStaffIdAndId(Integer id);
public List<Schedule> selectSchodule();
public List<ScheduleDto> selectSchoduleMouth();


// 학사일정 조회 (디테일)
public ScheduleDto selectScheduleById(Integer id);

// 월별 학사일정 조회
public List<Schedule> selectListByMonth(Integer month);

}
