package com.harrybro.courseregistration.global.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ResponseDto<T> {

    String message;
    LocalDateTime responseTime;
    T data;

    @Builder
    public ResponseDto(String message, T data) {
        this.message = message;
        this.responseTime = LocalDateTime.now();
        this.data = data;
    }

    public static <T> ResponseDto<T> of(String message, T data) {
        return ResponseDto.<T>builder().message(message).data(data).build();
    }

    public static ResponseDto<?> from(String message) {
        return ResponseDto.builder().message(message).build();
    }

}
