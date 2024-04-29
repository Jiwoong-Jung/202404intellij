package com.example.springedu.repository;

import com.example.springedu.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
	public List<Meeting> findByTitleContains(String keyword);	
	public List<Meeting> findByName(String name);
}
