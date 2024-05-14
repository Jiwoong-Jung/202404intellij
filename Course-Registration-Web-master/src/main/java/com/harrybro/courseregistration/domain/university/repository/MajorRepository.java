package com.harrybro.courseregistration.domain.university.repository;

import com.harrybro.courseregistration.domain.university.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Integer> {
}
