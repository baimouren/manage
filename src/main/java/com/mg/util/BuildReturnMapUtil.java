package com.mg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @Description: 控制层返回结果处理类
 * @author Zhangjc
 * @date 2016年4月13日 下午6:03:51
 */
public class BuildReturnMapUtil {

    private static final Logger log = Logger.getLogger(BuildReturnMapUtil.class);

    public static Map<String, Object> getReturnMap() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }

    /**
     * @Description: 构造返回
     * @author Zhangjc
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(Object obj) {
        if (obj instanceof Exception) {
            Exception e = (Exception) obj;
            return getReturnMap("", e, null);
        } else {
            return getReturnMap("", null, obj);
        }
    }

    /**
     * @Description: 含有异常的处理
     * @author Zhangjc
     * @param successMsg
     * @param e
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(String successMsg, Exception e, Object obj) {

        String errorCode = "-1";
        String errorMsg = "";
        boolean success = true;

        if (e != null) {
            log.error(e);
            success = false;
            errorMsg = e.getMessage();
        }else{
            if (successMsg.isEmpty()) {
                successMsg = "操作成功";
            }
        }

        return getReturnMap(successMsg, errorMsg, errorCode, obj, success);
    }

    /**
     * @Description: 处理最终的实现
     * @author Zhangjc
     * @param successMsg
     * @param errorMsg
     * @param errorCode
     * @param obj
     * @return
     */
    public static Map<String, Object> getReturnMap(String successMsg, String errorMsg, String errorCode, Object obj, boolean success) {
        int total = 0;
        if (obj instanceof List) {
            total = ((List<?>) obj).size();
        }
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("successMsg", successMsg);
        result.put("errorCode", errorCode);
        result.put("errorMsg",errorMsg );
        result.put("rows", obj == null ? new ArrayList<>() : obj);
        result.put("success", success);
        result.put("total", total);
        
        return result;
    }

    public static Map<String, Object> getReturnPageMap(Map<String, Object> map) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("successMsg", "操作成功");
        result.put("errorCode", "-1");
        result.put("errorMsg", null);
        result.put("rows", map.get("list") == null ? new ArrayList<>() : map.get("list"));
        result.put("success", true);
        result.put("total", map.get("total"));

        return result;
    }


}
