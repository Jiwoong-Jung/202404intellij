package com.sky._sb0409.repository;

import com.sky._sb0409.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
