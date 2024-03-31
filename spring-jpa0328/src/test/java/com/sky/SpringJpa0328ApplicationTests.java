package com.sky;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sky.model.Product;
import com.sky.repository.ProductMapper;
import com.sky.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class SpringJpa0328ApplicationTests {

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
    private ProductService productService;

	@Test
	void contextLoads() {
		log.debug("products 레코드 수 {}", productMapper.count());
	}
	
	@Test
    public void getProductById() {
        Product product = productService.getProductById(1L);
        log.info("product : {}", product);
    }
	
	@Test
    public void getAllProducts() {
        List<Product> products = productService.getAllProducts();
        log.info("products : {}", products);
    }

    @Transactional
    @Test
    public void addProduct() {
        productService.addProduct(new Product("쿤달 샴푸", 7900));
        productService.addProduct(new Product("마스크팩", 1000));
        productService.addProduct(new Product("티셔츠", 5900));
    }

}
