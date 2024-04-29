package com.example.springedu.repository;

import com.example.springedu.entity.Meeting;
import com.example.springedu.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	public List<Reply> findByRefid(Meeting vo);
	public List<Reply> findByRefidId(int id);
	@Query("select DISTINCT t from Reply t join fetch t.refid")
	public List<Reply> findAllJoinFetch();
}


//public List<Reply> findByRefidId(int id);