package com.sky.repository;

import com.sky.spring.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IMemberDao {

    @Select("select count(*) from member")
    int countMember();

    @Select("select * from member where email = #{email}")
    public Member selectByEmail(String email);

    @Insert("insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
            "values (#{member.email}, #{member.password}, #{member.name}, #{member.regdate})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    //SQL이 생성한 KEY 값을 매핑된 객체의 id 필드에도 담아주겠다.
    public int insert(@Param("member") Member member);
}
