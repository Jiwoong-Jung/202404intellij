package com.example.springedu;

import com.example.springedu.entity.Emp;
import com.example.springedu.repository.EmpRepository2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
@DataJpaTest
public class JPA_EmpRepository2Test2 {
    @Autowired
    private EmpRepository2 empR;
    
    @BeforeEach()
    void pr() {
    	System.out.println("==========================================================");
    }

    @Test
    @Order(1)
    void bySalLessThan() {
    	List<Emp> list = empR.findBySalLessThan(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(2)
    void bySalLessThanEqual() {
    	List<Emp> list = empR.findBySalLessThanEqual(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(3)
    void bySalBetween() {
    	List<Emp> list = empR.findBySalBetween(2000, 3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(4)
    void byCommNull() {
    	List<Emp> list = empR.findByCommNull();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(5)
    void byCommNotNull() {
    	List<Emp> list = empR.findByCommNotNull();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(6)
    void byHiredateAfter() {
    	List<Emp> list = empR.findByHiredateAfter(java.sql.Date.valueOf("1981-12-31"));
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(7)
    void byHiredateBefore() {
    	List<Emp> list = empR.findByHiredateBefore(java.sql.Date.valueOf("1981-12-31"));
    	list.stream().forEach(System.out::println);
    }
   
    @Test
    @Order(8)
    void byEnameStartsWith() {
    	List<Emp> list = empR.findByEnameStartsWith("M");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(9)
    void byEnameContains() {
    	List<Emp> list = empR.findByEnameContains("LA");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(10)
    void byDeptnoOrderBySalDesc() {
    	List<Emp> list = empR.findByDeptnoOrderBySalDesc(20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(11)
    void byTop3DeptnoOrderBySalDesc() {
    	List<Emp> list = empR.findTop3ByDeptnoOrderBySalDesc(20);
    	list.stream().forEach(System.out::println);
    }
}
