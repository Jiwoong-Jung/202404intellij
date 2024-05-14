package com.sky._sb0507.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final MemberDao memberDao;

	public AuthInfo authenticate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getId(),
				member.getEmail(),
				member.getName());
	}

}
