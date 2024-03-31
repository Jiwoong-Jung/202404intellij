package com.sky.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Orders {
	

	private Long orderId;

	@NonNull private Long memberId;
	@NonNull private Long prodId;
	@NonNull private Integer count;
	

}
