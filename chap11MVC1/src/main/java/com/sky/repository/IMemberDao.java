package com.sky.repository;

import com.sky.spring.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IMemberDao {

    @Select("select count(*) from member")
    int countMember();

    @Select("select * from member where email = #{email}")
    public Member selectByEmail(String email);
}
