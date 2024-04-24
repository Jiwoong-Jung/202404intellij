package com.sky._sb0423.practice.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class InputRequest {
    @NotEmpty
    private String name;

    private Integer age;

    private String phone;

    private String email;
    private String addr;
}
