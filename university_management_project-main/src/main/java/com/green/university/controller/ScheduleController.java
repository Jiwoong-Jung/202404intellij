package com.green.university.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.university.dto.ScheduleDto;
import com.green.university.dto.ScheduleFormDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.Schedule;
import com.green.university.service.ScheuleService;
import com.green.university.utils.Define;

/**
 * 
 * @author 편용림
 *
 */

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	private HttpSession session;

	@Autowired
	private ScheuleService scheuleService;

	/**
	 * 학사일정 페이지
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("")
	public String schedule(Model model) {

		// 전체조회
		List<Schedule> schedule = scheuleService.readSchedule();
		// 월에 일정 수 조회
		model.addAttribute("schedule", schedule);
		return "/schedule/schedule";

	}

	@GetMapping("/list")
	public String ScheduleList(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<Schedule> schedule = scheuleService.readSchedule();
		model.addAttribute("schedule", schedule);

		return "/schedule/scheduleList";
	}

	
	//일정 추가
	
	@PostMapping("/write")
	public String ScheduleProc(Model model, ScheduleFormDto scheduleFormDto) {
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		System.out.println("write");
		System.out.println(scheduleFormDto);
		
		if (scheduleFormDto.getStartDay().equals("")){
			throw new CustomRestfullException("날짜를 입력해주세요", HttpStatus.BAD_REQUEST);
		}else if(scheduleFormDto.getEndDay().equals("")){
			throw new CustomRestfullException("날짜를 입력해주세요", HttpStatus.BAD_REQUEST);
		}else if(scheduleFormDto.getInformation().equals("")){
			throw new CustomRestfullException("내용을 입력해주세요", HttpStatus.BAD_REQUEST);
		}else {
			scheuleService.createSchedule(principal.getId(), scheduleFormDto);
		}
		

		return "redirect:/schedule/list";
	}

	@GetMapping("/delete")
	public String deleteSchedule(Model model, @RequestParam Integer id) {
		model.addAttribute("id", id);
		scheuleService.deleteSchedule(id);

		return "redirect:/schedule/list";
	}

	@GetMapping("/detail")
	public String detailSchedule(Model model, Integer id, @RequestParam(defaultValue = "read") String crud) {
		ScheduleDto schedule = scheuleService.readScheduleById(id);
		model.addAttribute("crud",crud);
		model.addAttribute("schedule", schedule);
		return "/schedule/detail";
	}

	@PostMapping("/update")
	public String updateSchedule(ScheduleFormDto scheduleFormDto) {
		 scheuleService.updateSchedule(scheduleFormDto);
		
		return "redirect:/schedule/list";
	}

}
