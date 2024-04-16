package com.sky._sb0411.custom;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class FormCommand {
	private String loginType;
	private String jobCode;
	private List<String> favoriteOs;
	private boolean allowNoti;

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

}
