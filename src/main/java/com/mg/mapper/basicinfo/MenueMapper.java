package com.mg.mapper.basicinfo;

import java.util.List;
import java.util.Map;

import com.mg.model.basicinfo.MenueModel;

public interface MenueMapper {
    public void insert(MenueModel menue);

    public void deletedById(int id);

    public List<MenueModel> selectById(Integer param);

    public List<MenueModel> selectAll();

    public List<MenueModel> selectByParam(MenueModel menue);

    public List<MenueModel> selectBySql(Map<String, String> map);

}
