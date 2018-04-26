package com.mg.controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 拦截器 ，解析请求
 * @author 程彬
 * @date 2018年3月7日 下午3:15:31
 */
public class ControllerInterceptor implements HandlerInterceptor {

    private static Logger log = Logger.getLogger(ControllerInterceptor.class);

	@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {

        log.debug("拦截...after...");

	}

	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
        log.debug("拦截...post...");

	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        log.debug("拦截...pre...");
        log.debug("请求方式...:" + request.getMethod());
        log.debug("getServletPath...:" + request.getServletPath());

        return true;
	}

}
