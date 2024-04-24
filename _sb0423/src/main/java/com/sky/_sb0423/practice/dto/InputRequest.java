package com.sky._sb0423.practice.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class InputRequest {
//    @NotEmpty
    @NotBlank
    private String name;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @Pattern(regexp = "^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$"
            , message = "스마트폰 형식을 틀립니다.")
    private String phone;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"
            , message = "이메일 형식을 틀립니다.")
    private String email;
    private String addr;
}
