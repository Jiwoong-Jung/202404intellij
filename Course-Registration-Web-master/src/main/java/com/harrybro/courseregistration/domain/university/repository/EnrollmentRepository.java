package com.harrybro.courseregistration.domain.university.repository;

import com.harrybro.courseregistration.domain.university.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}
