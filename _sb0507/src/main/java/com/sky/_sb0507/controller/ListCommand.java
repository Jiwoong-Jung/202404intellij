package com.sky._sb0507.controller;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class ListCommand {

	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime from;
	@DateTimeFormat(pattern = "yyyyMMddHH")
	private LocalDateTime to;

	public LocalDateTime getFrom() {
		return from;
	}

	public void setFrom(LocalDateTime from) {
		this.from = from;
	}

	public LocalDateTime getTo() {
		return to;
	}

	public void setTo(LocalDateTime to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "ListCommand [from=" + from + ", to=" + to + "]";
	}
	
	

}
