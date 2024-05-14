package com.harrybro.courseregistration.domain.university.controller;

import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.university.dto.LectureSearchBy;
import com.harrybro.courseregistration.domain.university.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LectureController {

    private final LectureService lectureService;

    @GetMapping("/lecture")
    public String getLecture(Model model) {
        List<Lecture> lectures = lectureService.findAll();
        model.addAttribute("lectures", lectures);
        return "lecture";
    }

    @GetMapping("/lecture/search")
    public String getLectureContaining(@RequestParam LectureSearchBy searchBy,
                                       @RequestParam String searchMessage, Model model) {
        List<Lecture> lectures = lectureService.searchLecture(searchBy, searchMessage);
        model.addAttribute("lectures", lectures);
        return "lecture";
    }

} 
