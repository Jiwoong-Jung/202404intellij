package com.sky._sb0401.service;

import com.sky._sb0401.entity.Board;
import com.sky._sb0401.entity.Member;
import com.sky._sb0401.entity.Memo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class MemoService {
    @PersistenceContext
    EntityManager em;


    @Transactional
    public Memo emInsert() {
        Memo memo = Memo.builder()
                .memoText("이것은 EM 테스트")
                .build();
        em.persist(memo);  // insert
        return memo;

    }

    public Memo emSelectOne(Long mno) {
        return em.find(Memo.class, mno);
    }

    @Transactional
    public void m1insert() {
        Member member = Member.builder().name("홍길동").password("1234").role("사용자").userId("hong").build();
        em.persist(member);
//        em.flush();
        Board board = Board.builder().cnt(0L).title("처음 제목").content("처음 글 내용").createDate(new Date()).member(member).build();
        em.persist(board);
//        em.flush();

    }

    public Board getBoardOne(Long seq) {
        Board board = em.find(Board.class, seq);

        return board;
    }

    public Member getMemberOne(Long id) {
        Member member = em.find(Member.class, id);

        return member;
    }
}
