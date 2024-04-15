package com.sky._sb0411.survey;

import lombok.Builder;

import java.util.Collections;
import java.util.List;


public class Question {

	private String title;
	private List<String> options;

	@Builder
	public Question(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public Question(String title) {
		this(title, Collections.<String>emptyList());
	}

	public String getTitle() {
		return title;
	}

	public List<String> getOptions() {
		return options;
	}

	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

	public static Question toDTO(com.sky._sb0411.entity.Question entity) {
		return Question.builder()
				.title(entity.getTitle())
				.options(entity.getOptions())
				.build();
	}

}
