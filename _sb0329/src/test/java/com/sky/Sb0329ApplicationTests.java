package com.sky;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sky.model.Member;
import com.sky.model.Product;
import com.sky.repository.MemberMapper;
import com.sky.repository.ProductMapper;
import com.sky.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class Sb0329ApplicationTests {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
    private ProductService productService;

	@Test
	@DisplayName("member 테이블 자료 건수")
	void memberCount() {
		log.info("member 수 {}", memberMapper.count());
	}
	
	@Test
	@DisplayName("member 테이블 전체 자료")
	void selectAllMember() {
		log.info("member: {}", memberMapper.selectAllMember());
	}
	
	
	@Test
	@DisplayName("member 테이블 자료")
	void selectAllMember1() {
		log.info("member: {}", memberMapper.selectMemberById(1L));
	}
	
	@Test
	@DisplayName("member 테이블 자료 입력")
	void insertMember() {
		Member member = Member.builder().name("김하나")
				.city("인천").street("부산")
				.zipcode("567-001").build();
		memberMapper.insertMember(member);
	}
	
	void contextLoads() {
		log.debug("products 레코드 수 {}", productMapper.count());
	}
	
	//@Test
    public void getProductById() {
        Product product = productService.getProductById(1L);
        log.info("product : {}", product);
    }
	
	//@Test
    public void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        log.info("products : {}", products);
    }

    //@Transactional
    //@Test
    public void addProduct() {
        productService.addProduct(new Product("쿤달 샴푸", 7900));
        productService.addProduct(new Product("마스크팩", 1000));
        productService.addProduct(new Product("티셔츠", 5900));
    }

}
