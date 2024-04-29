package com.example.springedu.repository;

import com.example.springedu.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MemberTeamLockerRepository extends JpaRepository<Member, Integer>{

	@Query("select m from Member m join m.team t where t.name = :tn")

	public List<Member> aaa1(@Param("tn") String tname);

	@Query("select m from Member m where m.team.name = :tn")
	public List<Member> aaa2(@Param("tn") String tname);

	public List<Member> findByTeamName(String name);

	@Query("select t.name from Member m join m.team t where m.username = :un")
	public String bbb1(@Param("un") String uname);

	@Query("select m.team.name from Member m where m.username = :un")
	public String bbb2(@Param("un") String uname);

	public TeamName getByUsername(String uname);

	public Member  getByLockerName(String lname);
	
	public List<Member> findByUsername(String username);

	public Long countByUsername(String username);
}

