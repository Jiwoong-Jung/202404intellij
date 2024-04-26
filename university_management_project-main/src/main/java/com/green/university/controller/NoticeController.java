package com.green.university.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.green.university.dto.NoticeFormDto;
import com.green.university.dto.NoticePageFormDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.Notice;
import com.green.university.service.NoticeService;
import com.green.university.utils.Define;

/**
 * 
 * @author 박성희 
 * Notice Controller
 *
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;

	/**
	 * 
	 * @return 공지사항 페이지
	 */
	@GetMapping("")
	public String notice(Model model, @RequestParam(defaultValue = "select") String crud) {
		model.addAttribute("crud", crud);
		NoticePageFormDto noticePageFormDto = new NoticePageFormDto();
		noticePageFormDto.setPage(0);
		List<Notice> noticeList = noticeService.readNotice(noticePageFormDto);
		Integer amount = noticeService.readNoticeAmount(noticePageFormDto);

		model.addAttribute("listCount", Math.ceil(amount / 10.0));
		if (noticeList.isEmpty()) {
			model.addAttribute("noticeList", null);
		} else {
			model.addAttribute("noticeList", noticeList);
		}
		return "/board/notice";
	}

	/**
	 * 
	 * @return 공지사항 입력 기능
	 */
	@PostMapping("/write")
	public String insertNotice(@Validated NoticeFormDto noticeFormDto) {

		MultipartFile file = noticeFormDto.getFile();
		if (file.isEmpty() == false) {
			if (file.getSize() > Define.MAX_FILE_SIZE) {
				throw new CustomRestfullException("파일 크기는 20MB 이상 클 수 없습니다.", HttpStatus.BAD_REQUEST);
			}
			try {
				String saveDirectory = Define.UPLOAD_DIRECTORY;
				File dir = new File(saveDirectory);
				if (dir.exists() == false) {
					dir.mkdirs();
				}
				UUID uuid = UUID.randomUUID();
				String fileName = uuid + "_" + file.getOriginalFilename();
				String uploadPath = Define.UPLOAD_DIRECTORY + File.separator + fileName;
				File destination = new File(uploadPath);
				file.transferTo(destination);
				noticeFormDto.setOriginFilename(file.getOriginalFilename());
				noticeFormDto.setUuidFilename(fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		noticeService.readNotice(noticeFormDto);
		return "redirect:/notice";
	}

	/**
	 * 
	 * @return 공지사항 상세 조회 기능
	 */
	@GetMapping("/read")
	public String selectByIdNotice(Model model, @RequestParam Integer id) {
		model.addAttribute("crud", "read");
		model.addAttribute("id", id);
		Notice notice = noticeService.readByIdNotice(id);
		if (notice == null) {
			model.addAttribute("notice", null);
		} else {
			model.addAttribute("notice", notice);
		}
		notice.setContent(notice.getContent().replace("\r\n", "<br>"));

		return "/board/notice";
	}

	/**
	 * 공지사항 페이지 이동
	 */
	@GetMapping("/list/{page}")
	public String showNoticeListByPage(Model model, @RequestParam(defaultValue = "select") String crud,
			@PathVariable Integer page) {
		model.addAttribute("crud", crud);
		NoticePageFormDto noticePageFormDto = new NoticePageFormDto();
		noticePageFormDto.setPage((page - 1) * 10);
		Integer amount = noticeService.readNoticeAmount(noticePageFormDto);
		List<Notice> noticeList = noticeService.readNotice(noticePageFormDto);
		model.addAttribute("listCount", Math.ceil(amount / 10.0));
		if (noticeList.isEmpty()) {
			model.addAttribute("noticeList", null);
		} else {
			model.addAttribute("noticeList", noticeList);
		}
		return "/board/notice";
	}

	/**
	 * 공지사항 검색 기능
	 */
	@GetMapping("/search")
	public String showNoticeByKeyword(Model model, NoticePageFormDto noticePageFormDto) {
		model.addAttribute("keyword", noticePageFormDto.getKeyword());
		model.addAttribute("crud", "selectKeyword");
		noticePageFormDto.setPage(0);
		List<Notice> noticeList = noticeService.readNoticeByKeyword(noticePageFormDto);
		Integer amount = noticeService.readNoticeAmount(noticePageFormDto);
		model.addAttribute("listCount", Math.ceil(amount / 10.0));
		if (noticeList.isEmpty()) {
			model.addAttribute("noticeList", null);
		} else {
			model.addAttribute("noticeList", noticeList);
		}
		return "/board/notice";
	}

	/**
	 * 공지사항 검색 기능 (키워드 검색 페이징 처리)
	 */
	@GetMapping("/search/{page}")
	public String showNoticeByKeywordAndPage(Model model, NoticePageFormDto noticePageFormDto,
			@PathVariable Integer page, @RequestParam String keyword) {
		model.addAttribute("keyword", noticePageFormDto.getKeyword());
		model.addAttribute("crud", "selectKeyword");
		noticePageFormDto.setPage((page - 1) * 10);
		List<Notice> noticeList = noticeService.readNoticeByKeyword(noticePageFormDto);
		Integer amount = noticeService.readNoticeAmount(noticePageFormDto);

		model.addAttribute("listCount", Math.ceil(amount / 10.0));
		if (noticeList.isEmpty()) {
			model.addAttribute("noticeList", null);
		} else {
			model.addAttribute("noticeList", noticeList);
		}
		return "/board/notice";
	}

	/**
	 * 
	 * @return 공지사항 수정 페이지
	 */
	@GetMapping("/update")
	public String update(Model model, @RequestParam Integer id) {
		model.addAttribute("crud", "update");
		model.addAttribute("id", id);

		Notice notice = noticeService.readByIdNotice(id);
		model.addAttribute("notice", notice);
		return "/board/notice";
	}

	/**
	 * 
	 * @return 공지사항 수정 기능
	 */
	@PutMapping("/update")
	public String update(@Validated NoticeFormDto noticeFormDto) {
		noticeService.updateNotice(noticeFormDto);
		return "redirect:/notice";
	}

	/**
	 * 
	 * @return 공지사항 삭제 조회 기능
	 */
	@GetMapping("/delete")
	public String delete(Model model, @RequestParam Integer id) {
		model.addAttribute("id", id);
		noticeService.deleteNotice(id);
		return "redirect:/notice";
	}
}
