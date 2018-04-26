package com.mg.mapper.basicinfo;

import java.util.List;

import com.mg.model.basicinfo.UserModel;

public interface UserMapper {
    public void insert(UserModel user);

    public void deletedById(int id);

    public List<UserModel> selectById(Integer param);
	
    public List<UserModel> selectAll();

    public List<UserModel> selectByParam(UserModel user);
	
	public UserModel selectModelByParam(UserModel user);
}
