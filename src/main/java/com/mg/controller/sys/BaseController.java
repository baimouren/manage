package com.mg.controller.sys;

import java.util.Map;

import com.mg.util.BuildReturnMapUtil;

public class BaseController {

    public Map<String, Object> getReturnMap() {

        return BuildReturnMapUtil.getReturnMap();
    }

    // �����ؽ���� ׷����ʾ��Ϣ��
    public Map<String, Object> getReturnMap(Object obj) {
        Map<String, Object> returnMap = BuildReturnMapUtil.getReturnMap(obj);
        return returnMap;
    }

    // �����ؽ���� ׷����ʾ��Ϣ�� ��ҳ
    public Map<String, Object> getReturnPageMap(Map<String, Object> map) {
        Map<String, Object> returnMap = BuildReturnMapUtil.getReturnPageMap(map);
        return returnMap;
    }

}
