package com.harrybro.courseregistration.domain.user.service;

import com.harrybro.courseregistration.global.infra.mail.domain.EmailAuthCode;
import com.harrybro.courseregistration.global.infra.mail.domain.EmailSubject;
import com.harrybro.courseregistration.global.infra.mail.repository.EmailAuthCodeRepository;
import com.harrybro.courseregistration.global.infra.mail.util.EmailAuthCodeGenerator;
import com.harrybro.courseregistration.global.infra.mail.util.EmailUtil;
import com.harrybro.courseregistration.domain.university.domain.Basket;
import com.harrybro.courseregistration.domain.university.domain.Enrollment;
import com.harrybro.courseregistration.domain.university.repository.BasketRepository;
import com.harrybro.courseregistration.domain.university.repository.EnrollmentRepository;
import com.harrybro.courseregistration.domain.user.constant.UserResponseMessage;
import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.domain.user.dto.SignUpRequest;
import com.harrybro.courseregistration.domain.user.exception.EmailDuplicateException;
import com.harrybro.courseregistration.domain.user.exception.EmailNotFoundException;
import com.harrybro.courseregistration.domain.user.exception.EmailNotVerifiedException;
import com.harrybro.courseregistration.domain.user.exception.UserExceptionMessage;
import com.harrybro.courseregistration.domain.user.repository.UserRepository;
import com.harrybro.courseregistration.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final EmailAuthCodeRepository emailAuthCodeRepository;
    private final EmailUtil emailUtil;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseDto<?> create(SignUpRequest dto) {
//        if (emailAuthCodeRepository.existsByEmail(dto.getEmail()))
//            throw new EmailNotVerifiedException(UserExceptionMessage.EMAIL_NOT_VERIFIED_EXCEPTION);
//        if (userRepository.existsByEmail(dto.getEmail()))
//            throw new EmailDuplicateException(UserExceptionMessage.EMAIL_DUPLICATE_EXCEPTION);

        EmailAuthCodeGenerator authCodeGenerator = new EmailAuthCodeGenerator();
        String authCode = authCodeGenerator.generateAuthCode();
        emailAuthCodeRepository.save(EmailAuthCode.builder()
                .email(dto.getEmail())
                .authCode(authCode)
                .build());

        String message = emailUtil.getEmailAuthMessage(dto.getEmail(), authCode);
        emailUtil.sendEmail(dto.getEmail(), EmailSubject.EMAIL_AUTH_REQUEST, message);

        Basket basket = basketRepository.save(new Basket());
        Enrollment enrollment = enrollmentRepository.save(new Enrollment());
        userRepository.save(dto.toEntity(passwordEncoder, basket, enrollment));
        return ResponseDto.from(UserResponseMessage.SiGN_UP_SUCCESS.getMessage());
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(UserExceptionMessage.EMAIL_NOT_FOUND_EXCEPTION));
    }

}
