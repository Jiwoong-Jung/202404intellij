package com.example.springedu.controller;

import com.example.springedu.entity.Visitor;
import com.example.springedu.repository.VisitorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class VisitorController {
	private VisitorRepository  repository;

	public VisitorController(VisitorRepository repository) {
		this.repository = repository;
	}
	@RequestMapping("/vlist")
	public ModelAndView list() {
		List<Visitor> list = null;
		list = repository.findAll();
		ModelAndView mav = new ModelAndView();	
		if (list.size() != 0) {
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping("/vsearch")
	public ModelAndView search(String key) {
		List<Visitor> list = null;
		//list = repository.findByMemoLike(key);
		list = repository.findByMemoContains(key);
		ModelAndView mav = new ModelAndView();
		if (list.size() != 0) {
			System.out.println(list);
			mav.addObject("list", list);
		} else {
			mav.addObject("msg", "추출된 결과가 없어요");
		}
		mav.setViewName("visitorView");
		return mav;
	}

	@RequestMapping(value = "/vdelete")
	@Transactional
	public ModelAndView delete(int id) {
		ModelAndView mav = new ModelAndView();
		try {
			repository.deleteById(id);			
			mav.addObject("list", repository.findAll());
		} catch(Exception e) {			
			mav.addObject("msg", "글 삭제에 실패했습니다.");
		}
		mav.setViewName("visitorView");
		return mav;
	}
	
	@RequestMapping(value = "/one", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Visitor one(int id) {
		Optional<Visitor> result = repository.findById(id);
		return result.get();		
	}

	@RequestMapping(value = "/vinsert", 
			                     method = RequestMethod.POST)
	@Transactional
	public String insert(Visitor vo, Model model) {
		try {
			repository.save(vo);			
			return "redirect:/vlist";
		} catch(Exception e) {			
			model.addAttribute("msg", "글 작성에 실패했습니다.");
		}
		return "visitorView";
	}
	
	@RequestMapping(value = "/vupdate", 
            method = RequestMethod.POST)
	@Transactional
	public String update(Visitor vo, Model model) {		
		try {
			Visitor entity = repository.findById(vo.getId()).get();
			entity.setName(vo.getName());	
			entity.setMemo(vo.getMemo());
			return "redirect:/vlist";
		} catch(Exception e) {						
			model.addAttribute("msg", "글 수정에 실패했습니다.");
		}
		return "visitorView";	
	}
}



