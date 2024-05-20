package com.sky._sb0520_2.service;

import com.sky._sb0520_2.member.MemberJoinRequestDto;
import com.sky._sb0520_2.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String addUser(MemberJoinRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity(passwordEncoder)).getUsername();
    }


}
