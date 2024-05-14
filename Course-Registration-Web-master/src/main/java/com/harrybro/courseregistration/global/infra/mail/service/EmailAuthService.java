package com.harrybro.courseregistration.global.infra.mail.service;

import com.harrybro.courseregistration.global.infra.mail.domain.EmailAuthCode;
import com.harrybro.courseregistration.global.infra.mail.repository.EmailAuthCodeRepository;
import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.domain.user.domain.UserStateType;
import com.harrybro.courseregistration.domain.user.exception.EmailNotFoundException;
import com.harrybro.courseregistration.domain.user.exception.UserExceptionMessage;
import com.harrybro.courseregistration.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class EmailAuthService {

    private final EmailAuthCodeRepository emailAuthCodeRepository;
    private final UserRepository userRepository;

    @Transactional
    public void emailValidate(String email, String authCode) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(UserExceptionMessage.EMAIL_NOT_FOUND_EXCEPTION));
        if (user.getState().equals(UserStateType.NORMAL)) return;
        EmailAuthCode emailAuthCode = emailAuthCodeRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(UserExceptionMessage.EMAIL_NOT_FOUND_EXCEPTION));

        emailAuthCode.validateCode(authCode);
        user.emailVerificationCompleted();
        emailAuthCodeRepository.delete(emailAuthCode);
    }

}
