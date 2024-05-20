package com.example.securitystudy.service.member;

import com.example.securitystudy.domain.member.MemberRepository;
import com.example.securitystudy.dto.Member.MemberJoinRequestDto;
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
