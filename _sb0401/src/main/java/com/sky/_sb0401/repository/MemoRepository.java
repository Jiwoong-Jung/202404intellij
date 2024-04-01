package com.sky._sb0401.repository;

import com.sky._sb0401.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MemoRepository extends JpaRepository<Memo, Long> {
}
