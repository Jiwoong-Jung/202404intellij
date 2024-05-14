package com.harrybro.courseregistration.domain.user.repository;

import com.harrybro.courseregistration.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String username);

//    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
