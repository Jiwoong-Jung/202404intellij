package com.sky.survey;

import com.sky.entity.AnswerEntity;
import com.sky.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/survey")
@Slf4j
public class SurveyController {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	IAnswerDao iAnswerDao;

	@GetMapping
	public String form(Model model) {
//		List<Question> questions = createQuestions();
//		model.addAttribute("questions", questions);
		model.addAttribute("questions", questionRepository.findAll());
		return "survey/problemForm";
	}

//	private List<Question> createQuestions() {
//		Question q1 = new Question("당신의 역할은 무엇입니까?",
//				Arrays.asList("서버", "프론트", "풀스택", "백엔드"));
//		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",
//				Arrays.asList("이클립스", "인텔리J", "서브라임"));
//		Question q3 = new Question("하고 싶은 말을 적어주세요.");
//		return Arrays.asList(q1, q2, q3);
//	}

	@PostMapping
	public String submit(AnswerEntity answerEntity) {
//		log.info("{}", answerEntity);
		answerRepository.save(answerEntity);
//		log.info("{}", answerRepository.findAll());
		List<AnswerEntity> list = answerRepository.findAll();
		list.forEach(s->{
			log.info("{}", s);
		});
		return "survey/submitted";
	}

	@GetMapping("/count")
	@ResponseBody
	public int count() {
		return iAnswerDao.countAnswer();
	}
	@GetMapping("/select")
	@ResponseBody
	public List<AnswerData> select() {
		return iAnswerDao.getByAnswerId(1L);
	}
	@GetMapping("/selectAll")
	@ResponseBody
	public List<AnswerDto> selectAll() {
		return iAnswerDao.getAll();
	}

}
