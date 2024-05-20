package com.sky.mybatisdynamic;

import com.sky.mybatisdynamic.dao.scott.Emp;
import com.sky.mybatisdynamic.dao.scott.EmpExample;
import com.sky.mybatisdynamic.mapper.scott.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class MybatisDynamicApplicationTests {

    @Autowired
    EmpMapper empMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void display() {
        System.out.println(empMapper.countByExample(null));
//        EmpExample example = new EmpExample();
//        example.setDistinct(true);
        List<Emp> list = empMapper.selectByExample(null);
        for (Emp emp : list) {
            System.out.println(emp.getEname());
        }
    }

}
