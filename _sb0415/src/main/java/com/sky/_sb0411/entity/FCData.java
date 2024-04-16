package com.sky._sb0411.entity;

import com.sky._sb0411.custom.FormCommand;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class FCData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String loginType;
	private String jobCode;
	@ElementCollection
	private List<String> favoriteOs;

	@Builder
	public FCData(String loginType, String jobCode, List<String> favoriteOs) {
		this.loginType = loginType;
		this.jobCode = jobCode;
		this.favoriteOs = favoriteOs;
	}

	public static FCData toEntity(FormCommand dto) {
		return FCData.builder()
				.jobCode(dto.getJobCode())
				.loginType(dto.getLoginType())
				.jobCode(dto.getJobCode())
				.favoriteOs(dto.getFavoriteOs())
				.build();
	}
}
