package com.sky._sb0419.repository;

import com.sky._sb0419.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into notice(title, content, regdate) values " +
            "(:#{#notice.title}, :#{#notice.content}, CURRENT_TIMESTAMP) "
            , nativeQuery = true)
    public void insertNotice(@Param("notice") Notice notice);

    @Query(value = "select count(*) from notice", nativeQuery = true)
    public Long selectCount();

    @Query(value = "select * from notice order by seq desc", nativeQuery = true)
    public List<Notice> selectOrderSeq();

    public List<Notice> findAllByOrderBySeqDesc();   // 쿼리메소드 라고 부름
}
