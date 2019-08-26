package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;

public class User {
	@Value("${com.test.id}")
	private Long id;
	@Value("${com.test.name")
	private String name;
	@Value("${com.test.age")
	private Integer age;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	

}
