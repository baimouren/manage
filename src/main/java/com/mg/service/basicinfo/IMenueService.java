package com.mg.service.basicinfo;

import java.util.List;
import java.util.Map;

import com.mg.model.basicinfo.MenueModel;

public interface IMenueService {

    // ≤È—Ø≤Àµ•
    public List<MenueModel> searchMenue(Map<String, String[]> param);
}
