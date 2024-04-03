package com.sky._sb0402.repository;

import com.sky._sb0402.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyDataRepository extends JpaRepository<MyData, Long> {

    List<MyData> findByIdBetween(Long id1, Long id2);  // 쿼리메소드

    @Query("select m from MyData m order by m.id desc")  // 일반적임
    List<MyData> findAll2();
}
