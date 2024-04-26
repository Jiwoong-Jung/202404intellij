package com.green.university.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.ChangePasswordDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.repository.model.User;

@Mapper
public interface UserRepository {
	
	// 로그인용
	public PrincipalDto selectById(Integer userId);
	
	// 패스워드 변경
	public int updatePassword(ChangePasswordDto changePasswordDto);
	
	// id 이용해서 user_tb에 insert
	public int insertToUser(User user);

}
