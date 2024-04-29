package com.example.springedu;

import com.example.springedu.entity.Emp;
import com.example.springedu.repository.EmpRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
// @DataJpaTest를 사용하면 자동으로 EmbededDatabase-H2를 사용하게 된다.
// MySQL과 같이 외부의 DB 를 연결하려는 경우엔 이 어노테이션을 설정한다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// @DataJpaTest : Spring에서 JPA 관련 테스트 설정만 로드한다.
// DataSource의 설정이 정상적인지, 제대로 생성 수정 삭제 조회 하는지 등의 테스트가 가능하다.
@DataJpaTest

public class JPA_EmpRepositoryTest {
    @Autowired
    private EmpRepository empR;

    @BeforeEach
    void pr() {
        System.out.println("=".repeat(80));
    }

    @Test
    void list1() {
    	List<Emp> list = empR.findAll();
    	list.stream().forEach(System.out::println);
    }
    @Test
    void list2() {
        List<Emp> list = empR.findAll(Sort.by("sal").descending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list3() {
        List<Emp> list = empR.findAll(Sort.by("sal").ascending());
        list.stream().forEach(System.out::println);
    }
    @Test
    void list4() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 2));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list5() {
        Page<Emp> list = empR.findAll(PageRequest.of(3, 4));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list6() {
        List<Emp> list = empR.findAll(Sort.by("ename"));
        list.stream().forEach(System.out::println);
    }
    @Test
    void list7() {
        Page<Emp> list = empR.findAll(PageRequest.of(0, 3, Sort.by("ename")));
        list.stream().forEach(System.out::println);
    }
}
