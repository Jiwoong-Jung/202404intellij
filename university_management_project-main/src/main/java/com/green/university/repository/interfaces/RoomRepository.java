package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.RoomFormDto;
import com.green.university.repository.model.Department;
import com.green.university.repository.model.Room;

/*
 *  박성희
 *  강의실 repository
 */

@Mapper
public interface RoomRepository {
	public int insert(RoomFormDto roomFormDto);
	public List<Room> selectByRoomDto();
	public int deleteById(String id);
}
