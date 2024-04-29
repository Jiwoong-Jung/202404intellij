package com.example.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value(value = "${uploadPath}")
    private String uploadPath;

    @Override
//    registry를 등록해서 쓸 수 있게 함
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**") // 접근을 이 주소로 하게 합니다
                .addResourceLocations(uploadPath);// 실제로는 여기
    }
}
