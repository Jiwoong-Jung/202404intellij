package com.example.securitystudy.config;

import com.example.securitystudy.domain.member.Member;
import com.example.securitystudy.domain.member.MemberRepository;
import com.example.securitystudy.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * packageName : com.example.securitystudy.config
 * fileName : MyUserDetailsService
 * author : SHW
 * date : 2023-06-14
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2023-06-14   SHW     최초 생성
 */

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("없는 회원 입니다..."));

        return User.builder().username(member.getUsername()).password(member.getPassword()).roles(member.getRole().name()).build();
    }
}
