package com.sky.restapi0513.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.OAS_30)
        		//DocumentationType.OAS_30 : Swagger 3.0 을 뜻함
                .select()
                //select() : ApiSelectorBuilder 생성
                .apis(RequestHandlerSelectors
                		.basePackage("com.sky.restapi0513.controller"))
                //apis() : Swagger을 적용할 API 선택
                //.apis(RequestHandlerSelectors.any())
                //RequestHandlerSelectors.any() : 프로젝트 내의 모든 패키지에 적용
                .paths(PathSelectors.any()) // 해당 경로를 문서화
                //PathSelectors.any() : 모든 API 통과
                .build()  // 빌드
                .apiInfo(mySwaggerInfo());
    }

    private ApiInfo mySwaggerInfo() {
        return new ApiInfoBuilder()
                .title("REST API 연습")
                .description("SwaggerTest API 문서")
                .build();
    }
}