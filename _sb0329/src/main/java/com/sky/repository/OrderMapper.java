package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.model.Orders;

@Mapper
public interface OrderMapper {
	
	@Select("select * from orders")
	List<Orders> selectAllOrders();

}
