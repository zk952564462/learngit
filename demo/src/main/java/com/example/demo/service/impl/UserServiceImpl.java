package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TestDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	public TestDao dao;
	
	@Override
	public List<User> getUser() {
		return null;
	}
	
}
