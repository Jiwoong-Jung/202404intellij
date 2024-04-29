package com.example.springedu.repository;

import com.example.springedu.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpRepository extends JpaRepository<Emp, Integer>{

}
