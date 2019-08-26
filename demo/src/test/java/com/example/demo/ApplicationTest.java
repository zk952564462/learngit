package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception{
		mvc=MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testusercontroller() throws Exception{
		MockHttpServletRequestBuilder request= null;
		request = MockMvcRequestBuilders.get("/users/");
		//andExpect：添加执行后的断言
		mvc.perform(request) 
		.andExpect(status().isOk()) 
		.andExpect(content().string(equalTo("[]")));
		
		//post提交一个user
		request = MockMvcRequestBuilders.post("/users/").param("id", "1").param("name", "测试大师").param("age","22");
		mvc.perform(request).andExpect(content().string(equalTo("SUCCESS")));
		
	}
}
