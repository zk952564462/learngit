package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/users")
public class UserController {
	//创建线程安全的Map
	static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());
	
	@ApiOperation(value="获取用户列表",notes="")
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> r=new ArrayList<User>(users.values());
		return r;
	}
	
	@ApiOperation(value="添加一个新的用户",notes="根据User对象创建用户")
	@ApiImplicitParam(name="user",value="用户详细实体user",required=true,dataType="User")
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		//除了@ModelAttribute绑定参数外，还可以通过@RequestParam从页面中传递参数
		users.put(user.getId(),user);
		System.out.print(user);
		return "SUCCESS";
	}
	
	@ApiOperation(value="获取用户详情信息",notes="根据url的id来获取用户详情信息")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		//处理“/users/{id}”中的get请求，用来获取url中id值的User信息
		//url 中的id可通过PathVariable绑定到函数的参数中
		return users.get(id);
	}
	
	@ApiOperation(value="更新用户详情信息",notes="根据url的id来更新用户的信息")
	@ApiImplicitParams({
				@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long"),
				@ApiImplicitParam(name="user",value="用户详情实体user",required=true,dataType="User")})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "SUCCESS";
	}
	
	
	@ApiOperation(value="删除用户信息",notes="根据url的id来删除用户的信息")
	@ApiImplicitParam(name="id",value="用户ID",required=true,dataType="Long")
	@RequestMapping(value="{/id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "SUCCESS";
	}
	
}
