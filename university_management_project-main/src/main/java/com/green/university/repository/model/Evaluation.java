package com.green.university.repository.model;

import java.awt.TextArea;

import lombok.Data;

@Data
public class Evaluation {

		private Integer evaluationId;
		private Integer studentId;
		private Integer subjectId;
		private Integer gna1;
		private Integer gna2;
		private Integer gna3;
		private Integer gna4;
		private Integer gna5;
		private Integer gna6;
		private Integer gna7;
		private TextArea improvements;

}
