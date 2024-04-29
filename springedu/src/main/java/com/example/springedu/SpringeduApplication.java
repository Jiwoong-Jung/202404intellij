package com.example.springedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//기동될 때 데이터 베이스의 관련 설정이 없으면 오류가 발생합니다.
//application.properties에서 DataSource 설정이 있으면 됩니다.
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.springedu.repository"})
@EntityScan(basePackages = {"com.example.springedu.entity"})
public class SpringeduApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringeduApplication.class, args);
	}

}
