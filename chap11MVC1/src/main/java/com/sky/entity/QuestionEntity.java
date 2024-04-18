package com.sky.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;

	@ElementCollection
	@CollectionTable(name = "question_data", joinColumns = @JoinColumn(name = "id"))
	@OrderColumn(name = "seq")
	private List<String> options;
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}

	@Builder
	public QuestionEntity(String title, List<String> options) {
		this.title = title;
		this.options = options;
	}

	public QuestionEntity(String title) {
		this.title = title;
	}
}
