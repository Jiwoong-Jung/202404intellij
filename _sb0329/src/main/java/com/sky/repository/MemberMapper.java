package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.model.Member;

@Mapper
public interface MemberMapper {
	@Select("select count(*) from member")
	int count();
	
	@Select("select * from member")
	List<Member> selectAllMember();
	
	Member selectMemberById(Long id);
	
	@Insert("INSERT INTO member (name, city, street, zipcode)\r\n"
			+ "        VALUES (#{name}, #{city}, #{street} , #{zipcode})")
	void insertMember(Member member);
}
