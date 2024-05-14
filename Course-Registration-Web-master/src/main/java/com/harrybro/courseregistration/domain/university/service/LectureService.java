package com.harrybro.courseregistration.domain.university.service;

import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.university.dto.LectureSearchBy;
import com.harrybro.courseregistration.domain.university.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<Lecture> findAll() {
        return this.lectureRepository.findAll();
    }

    public List<Lecture> searchLecture(LectureSearchBy searchBy, String searchMessage) {
        if (searchBy.equals(LectureSearchBy.LECTURER_AND_NAME))
            return lectureRepository.findByNameContainingOrLecturerContaining(searchMessage, searchMessage);
        else if (searchBy.equals(LectureSearchBy.LECTURER))
            return lectureRepository.findByLecturerContaining(searchMessage);
        else if (searchBy.equals(LectureSearchBy.NAME))
            return lectureRepository.findByNameContaining(searchMessage);
        return null;
    }
}
