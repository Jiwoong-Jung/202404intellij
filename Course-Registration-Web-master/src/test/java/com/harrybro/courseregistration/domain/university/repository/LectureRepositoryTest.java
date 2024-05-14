package com.harrybro.courseregistration.domain.university.repository;

import com.harrybro.courseregistration.domain.university.domain.Lecture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LectureRepositoryTest {

    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private MajorRepository majorRepository;

    @Test
    void findByNameContaining() {
        List<Lecture> lectures = lectureRepository.findByNameContaining("경");
        assertThat(lectures.get(0).getName())
                .isNotEmpty()
                .contains("경");
    }

    @Transactional
    @Test
    void saveLecture() {
//        Lecture lecture = Lecture.builder()
//                .name("test lecture")
//                .lecturer("lecturer1")
//                .major(majorRepository.findById(1).get())
//                .credit(3)
//                .time(ClassPeriod.ONE_PERIOD)
//                .build();
//
//        lectureRepository.save(lecture);
//        Lecture foundLecture = lectureRepository.findByLecturerContaining("lecturer1").get(0);
//        assertThat(foundLecture).isEqualTo(lecture);
    }

}