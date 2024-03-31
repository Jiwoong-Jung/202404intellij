package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.model.Orders;
import com.sky.repository.OrderMapper;

@Service
public class OrderService {

	@Autowired
	OrderMapper orderMapper;
	
	public List<Orders> getAllOrders() {
        return orderMapper.selectAllOrders();
    }

}
