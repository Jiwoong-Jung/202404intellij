package com.harrybro.courseregistration.domain.university.repository;

import com.harrybro.courseregistration.domain.university.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findByNameContaining(String name);

    List<Lecture> findByLecturerContaining(String lecturer);

    List<Lecture> findByNameContainingOrLecturerContaining(String name, String lecturer);

}
