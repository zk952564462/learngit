package com.example.demo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.error.TestException;

@RestController
public class ErrorController {

	
	@RequestMapping(value="/")
	public String index(ModelMap map) {
		map.addAttribute("host","https://www.baidu.com");
		return "index";
	}
	@RequestMapping(value="/test")
	public String hello() throws Exception{
		throw new Exception("发生错误");
	}
	@RequestMapping(value="/json")
	public String json() throws TestException{
		throw new TestException("发生错误2");
	}
}
