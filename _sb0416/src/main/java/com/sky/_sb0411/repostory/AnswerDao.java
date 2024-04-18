package com.sky._sb0411.repostory;

import com.sky._sb0411.entity.Answer;
import com.sky._sb0411.problem.AnswerDTO;
import com.sky._sb0411.problem.AnswerDataList;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerDao {
    @Select("select count(*) from answer")
    int countAnswer();

    @Select("SELECT * FROM answer")
    @Results(id="AnswerMap", value={
            @Result(property="id", column="id"),
            @Result(property="age", column="age"),
            @Result(property="name", column="name"),
            @Result(property="dataList", javaType = List.class, column="id", many=@Many(select="com.sky._sb0411.repostory.getByAnswerId"))
    })
    List<AnswerDTO> getAll();

    @Select("SELECT * FROM ANSWER_DATA_LIST where answer_id=#{id}")
    @Results({
            @Result(property="answerId", column="answer_id"),
            @Result(property="dataList", column="data_list"),
            @Result(property="dataListOrder", column="data_list_order")
    })
    List<AnswerDataList> getByAnswerId(@Param("id") int answer_id);
}
