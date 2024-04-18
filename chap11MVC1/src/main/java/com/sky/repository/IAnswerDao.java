package com.sky.repository;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IAnswerDao {
    @Select("select count(*) from answer")
    int countAnswer();
    @Select("SELECT * FROM ANSWER")
    @Results({
            @Result(property="id", column="id"),
            @Result(property="age", column="age"),
            @Result(property="name", column="name"),
            @Result(property="dataList", javaType = List.class, column="id",
                                            many=@Many(select="getByAnswerId"))
    })
    List<AnswerDto> getAll();

    @Select("SELECT * FROM ANSWER_DATA WHERE ID=#{id}")
    @Results({
            @Result(property="id", column="id"),
            @Result(property="dataList", column="data_list"),
            @Result(property="seq", column="seq")
    })
    List<AnswerData> getByAnswerId(@Param("id") Long id);

}
