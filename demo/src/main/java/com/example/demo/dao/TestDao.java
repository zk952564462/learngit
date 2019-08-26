package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import com.example.demo.pojo.User;

@Mapper
public interface TestDao {
	
	@Select("select * from users")	
	@Results({
		@Result(property = "name" , column="name"),
		@Result(property = "age",column="age"),
	})
	List<User> getAll();
	
	
}
