package com.mg.service.basicinfo.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.mapper.basicinfo.UserMapper;
import com.mg.model.basicinfo.UserModel;
import com.mg.service.basicinfo.ILoginService;

@Service(value="loginService")
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private UserMapper userMapper;
	
	public UserModel loginByNameAndPassword(Map<String, String[]> param) {
		UserModel user = new UserModel();
		user.setLoginName(param.get("loginName")[0]);
		user.setPassword(param.get("passWord")[0]);
		UserModel selectModelByParam = userMapper.selectModelByParam(user);
		return selectModelByParam;
	}

}
