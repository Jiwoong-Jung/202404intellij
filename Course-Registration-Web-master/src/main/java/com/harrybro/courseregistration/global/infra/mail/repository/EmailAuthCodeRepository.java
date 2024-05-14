package com.harrybro.courseregistration.global.infra.mail.repository;

import com.harrybro.courseregistration.global.infra.mail.domain.EmailAuthCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmailAuthCodeRepository extends JpaRepository<EmailAuthCode, Long> {

    Optional<EmailAuthCode> findByEmail(String email);

    boolean existsByEmail(String email);

}
