package com.green.university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.university.dto.CollTuitFormDto;
import com.green.university.dto.CollegeFormDto;
import com.green.university.dto.DepartmentFormDto;
import com.green.university.dto.RoomFormDto;
import com.green.university.dto.SubjectFormDto;
import com.green.university.repository.model.College;
import com.green.university.repository.model.Department;
import com.green.university.repository.model.Room;
import com.green.university.repository.model.Subject;
import com.green.university.service.AdminService;

/**
 * 
 * @author 박성희 
 * Admin 수업 조회/입력 관련 Controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	/**
	 * 
	 * @return 단과대 페이지
	 */
	@GetMapping("/college")
	public String college(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<College> collegeList = adminService.readCollege();
		if (collegeList.isEmpty()) {
			model.addAttribute("collegeList", null);
		} else {
			model.addAttribute("collegeList", collegeList);
		}
		return "/admin/college";
	}

	/**
	 * 
	 * @return 단과대학 입력 기능
	 */
	@PostMapping("/college")
	public String collegeProc(CollegeFormDto collegeFormDto) {
		adminService.createCollege(collegeFormDto);
		return "redirect:/admin/college";
	}

	/**
	 * 
	 * @return 단과대학 삭제 기능
	 */
	@GetMapping("/collegeDelete")
	public String deleteCollege(Model model, @RequestParam Integer id) {
		model.addAttribute("id", id);
		adminService.deleteCollege(id);
		return "redirect:/admin/college";
	}

	/**
	 * 
	 * @return 학과 페이지 페이지 이동 시, 단과대학 조회 후 이동
	 */
	@GetMapping("/department")
	public String department(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<Department> departmentList = adminService.readDepartment();
		List<College> collegeList = adminService.readCollege();
		if (collegeList.isEmpty()) {
			model.addAttribute("collegeList", null);
		} else {
			model.addAttribute("collegeList", collegeList);
		}
		if (departmentList.isEmpty()) {
			model.addAttribute("departmentList", null);
		} else {
			model.addAttribute("departmentList", departmentList);
		}
		return "/admin/department";
	}

	/**
	 * 
	 * @return 학과 입력 기능
	 */
	@PostMapping("/department")
	public String departmentProc(DepartmentFormDto departmentFormDto) {
		adminService.createDepartment(departmentFormDto);
		return "redirect:/admin/department";
	}

	/**
	 * 
	 * @return 학과 삭제 기능
	 */
	@GetMapping("/departmentDelete")
	public String deleteDepartment(Model model, @RequestParam Integer id) {
		model.addAttribute("id", id);
		adminService.deleteDepartment(id);
		return "redirect:/admin/department";
	}

	/**
	 * 
	 * @return 학과 수정 기능
	 */
	@PutMapping("/department")
	public String updateDepartment(DepartmentFormDto departmentFormDto) {
		adminService.updateDepartment(departmentFormDto);
		return "redirect:/admin/department";
	}

	/**
	 * 
	 * @return 강의실 페이지
	 */
	@GetMapping("/room")
	public String room(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<Room> roomList = adminService.readRoom();
		List<College> collegeList = adminService.readCollege();
		if (collegeList.isEmpty()) {
			model.addAttribute("collegeList", null);
		} else {
			model.addAttribute("collegeList", collegeList);
		}
		if (roomList.isEmpty()) {
			model.addAttribute("roomList", null);
		} else {
			model.addAttribute("roomList", roomList);
		}
		return "/admin/room";
	}

	/**
	 * 
	 * @return 강의실 입력 기능
	 */
	@PostMapping("/room")
	public String roomProc(RoomFormDto roomFormDto) {
		adminService.createRoom(roomFormDto);
		return "redirect:/admin/room";
	}

	/**
	 * 
	 * @return 강의실 삭제 기능
	 */
	@GetMapping("/roomDelete")
	public String deleteRoom(Model model, @RequestParam String id) {
		model.addAttribute("id", id);
		adminService.deleteRoom(id);
		return "redirect:/admin/room";
	}

	/**
	 * 
	 * @return 강의 페이지
	 */
	@GetMapping("/subject")
	public String subject(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<Subject> subjectList = adminService.readSubject();
		List<College> collegeList = adminService.readCollege();
		if (collegeList.isEmpty()) {
			model.addAttribute("collegeList", null);
		} else {
			model.addAttribute("collegeList", collegeList);
		}
		if (subjectList.isEmpty()) {
			model.addAttribute("subjectList", null);
		} else {
			model.addAttribute("subjectList", subjectList);
		}
		return "/admin/subject";
	}

	/**
	 * 
	 * @return 강의 입력 기능
	 */
	@PostMapping("/subject")
	public String insertSubject(SubjectFormDto subjectFormDto) {
		adminService.createSubjectAndSyllabus(subjectFormDto);
		return "redirect:/admin/subject";
	}

	/**
	 * 
	 * @return 강의 삭제 기능
	 */
	@GetMapping("/subjectDelete")
	public String deleteSubject(Model model, @RequestParam Integer id) {
		model.addAttribute("id", id);
		adminService.deleteSubject(id);
		return "redirect:/admin/subject";
	}

	/**
	 * 
	 * @return 강의 수정 기능
	 */
	@PutMapping("/subject")
	public String updateSubject(SubjectFormDto subjectFormDto) {
		adminService.updateSubject(subjectFormDto);
		return "redirect:/admin/subject";
	}

	/**
	 * 
	 * @return 단과대별 등록금 페이지
	 */
	@GetMapping("/tuition")
	public String collTuit(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		List<CollTuitFormDto> collTuitList = adminService.readCollTuit();
		List<College> collegeList = adminService.readCollege();
		if (collegeList.isEmpty()) {
			model.addAttribute("collegeList", null);
		} else {
			model.addAttribute("collegeList", collegeList);
		}
		if (collTuitList.isEmpty()) {
			model.addAttribute("collTuitList", null);
		} else {
			model.addAttribute("collTuitList", collTuitList);
		}
		return "/admin/collTuit";
	}

	/**
	 * 
	 * @return 단과대별 등록금 입력 기능
	 */
	@PostMapping("/tuition")
	public String insertcollTuit(CollTuitFormDto collTuitFormDto) {
		adminService.createCollTuit(collTuitFormDto);
		return "redirect:/admin/tuition";
	}

	/**
	 * 
	 * @return 단과대 등록금 삭제 기능
	 */
	@GetMapping("/tuitionDelete")
	public String deleteCollTuit(Model model, @RequestParam Integer collegeId) {
		model.addAttribute("collegeId", collegeId);
		adminService.deleteCollTuit(collegeId);
		return "redirect:/admin/tuition";
	}

	/**
	 * 
	 * @return 단과대 등록금 수정 기능
	 */
	@PutMapping("/tuitionUpdate")
	public String updateCollTuit(CollTuitFormDto collTuitFormDto) {
		adminService.updateCollTuit(collTuitFormDto);
		return "redirect:/admin/tuition";
	}

}
