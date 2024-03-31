package com.sky;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.sky.repository.ProductMapper;

@WebMvcTest
public class MyControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ProductMapper productMapper;
	
	@Test
	public void testHello() throws Exception {
		mockMvc.perform(get("/test")).andExpect(status().isOk()).andExpect(content().string("hello"))
		.andDo(print());
	}
	
	@Test
	@DisplayName("GET 요청")
	public void callGetTest() throws Exception{
		mockMvc.perform(get("/test2"))
		
//	    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	    .andExpect(status().isOk())
	    .andExpect(content().contentTypeCompatibleWith("application/json"))
	    .andExpect(jsonPath("$.prodId").value(3))
	    .andExpect(jsonPath("$.prodName").value("버킷햇3"))
	    .andExpect(jsonPath("$.prodPrice").value(7100)).andDo(print());
		
//		mockMvc.perform(get("/index").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith("application/json"))
//        .andExpect(jsonPath("$.greeting").value("Hello World"));
	}

}
