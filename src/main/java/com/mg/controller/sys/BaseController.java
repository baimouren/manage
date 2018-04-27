package com.mg.controller.sys;

import java.util.Map;

import com.mg.util.BuildReturnMapUtil;

public class BaseController {

    public Map<String, Object> getReturnMap() {

        return BuildReturnMapUtil.getReturnMap();
    }

    // 处理返回结果集 追加提示信息等
    public Map<String, Object> getReturnMap(Object obj) {
        Map<String, Object> returnMap = BuildReturnMapUtil.getReturnMap(obj);
        return returnMap;
    }

    // 处理返回结果集 追加提示信息等 分页
    public Map<String, Object> getReturnPageMap(Map<String, Object> map) {
        Map<String, Object> returnMap = BuildReturnMapUtil.getReturnPageMap(map);
        return returnMap;
    }

}
