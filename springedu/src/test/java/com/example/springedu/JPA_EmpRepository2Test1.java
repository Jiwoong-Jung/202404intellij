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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@DataJpaTest를 사용하면 자동으로 EmbededDatabase-H2를 사용
//MySQL과 같이 외부의 DB를 연결하려는 경우에 이 어노테이션을 설정한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)

//스프링 부트 JPA Test를 위한 애노테이션
//DataSource의 설정이 정상적인지, 제대로 생성 수정 삭제 조회 하는지 등의 테스트가 가능하다.
@DataJpaTest
public class JPA_EmpRepository2Test1 {
    @Autowired
    private EmpRepository2 empR;
    
    @BeforeEach
    void pr() {
    	System.out.println("==========================================================");
    }
    
    @Test
    @Order(1)
    //@Rollback(false) // Test는 rollback이 기본이기 때문에 DML 문 수행한 후에 rollback 하고싶지 않다면 사용합니다.
    @Transactional
    void save() {
    	Emp entity = new Emp();
    	entity.setEmpno(1234);
    	entity.setEname("유니코1");
    	entity.setJob("강의");
    	entity.setMgr("7566");
    	entity.setHiredate(new java.sql.Date(System.currentTimeMillis()));
    	entity.setSal(3000);
    	entity.setComm(300);
    	entity.setDeptno(30);
    	empR.save(entity);//테스트 용도이기 때문에 실제 데이터 베이스에 저장되지 않아요. 저장하려면 @Rollback(false)
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(2)
    void list() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
   @Test
   @Order(3)
    void byId() {
    	Emp entity = empR.findById(7788).get();
    	System.out.println(entity);
    }
    @Test
    @Order(4)
    void byName() {
    	List<Emp> list = empR.findByEname("SMITH");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(5)
    void byNameIgnoreCase() {
    	List<Emp> list = empR.findByEnameIgnoreCase("smith");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(6)
    void byJob() {
    	List<Emp> list = empR.findByJob("SALESMAN");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(7)
    void byJobOrDeptno() {
    	List<Emp> list = empR.findByJobOrDeptno("MANAGER", 20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(8)
    void byJobAndDeptno() {
    	List<Emp> list = empR.findByJobAndDeptno("MANAGER", 20);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(9)
    void byDistinctByJob() {
    	List<Emp> list = empR.findDistinctByJob("SALESMAN");
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(10)
    void byDeptno() {
    	List<Emp> list = empR.findByDeptno(30);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(11)
    void bySalGreaterThan() {
    	List<Emp> list = empR.findBySalGreaterThan(3000);
    	list.stream().forEach(System.out::println);
    }
    @Test
    @Order(12)
    void bySalGreaterThanEqual() {
    	List<Emp> list = empR.findBySalGreaterThanEqual(3000);
    	list.stream().forEach(System.out::println);
    }
}
