package com.mg.service.basicinfo;

import java.util.Map;

import com.mg.model.basicinfo.UserModel;

public interface ILoginService {

	public UserModel loginByNameAndPassword(Map<String, String[]> param);

}
