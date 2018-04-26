package com.mg.service.basicinfo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.mapper.basicinfo.MenueMapper;
import com.mg.model.basicinfo.MenueModel;
import com.mg.service.basicinfo.IMenueService;

@Service("menueService")
public class MenueServiceImpl implements IMenueService {

    @Autowired
    private MenueMapper menueMapper;

    private static Logger log = Logger.getLogger(MenueServiceImpl.class);

    @Override
    public List<MenueModel> searchMenue(Map<String, String[]> param) {
        log.info(param);
        List<MenueModel> menueList = null;
        Map<String, String> map = new HashMap<>();
        map.put("sql", null);
        if ((param.get("menueName")[0]).trim() != null && (param.get("menueName")[0]).trim() != "") {
            StringBuffer strb = new StringBuffer();
            strb.append(" AND LIKE '%" + param.get("menueName")[0] + "%' ");
            map.put("sql", strb.toString());
            menueList = menueMapper.selectBySql(map);
        } else {
            menueList = menueMapper.selectAll();
        }
        return menueList;
    }

}
