package com.sky.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IMemberDao {

    @Select("select count(*) from member")
    int countMember();
}
