package com.mg.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mg.model.basicinfo.UserModel;
import com.mg.service.basicinfo.ILoginService;

@Component
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);

	@Autowired
	private ILoginService loginService;
	
	@ResponseBody
	@RequestMapping("/loginByNameAndPassword")
	public Map<String,String> loginByNameAndPassword(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		Map<String,String> map = new HashMap<String, String>();
		Map<String, String[]> param = request.getParameterMap();
        UserModel user = null;
        String message = null;
        try {
            user = loginService.loginByNameAndPassword(param);
        }
        catch (Exception e) {
            Throwable cause = e.getCause().getCause();
            message = cause.getMessage();

            if (message.contains("Could not get JDBC Connection;")) {
                log.error("-----------------------���ݿ�����ʧ�ܣ�-----------------------");
            }
        }
		if(user != null){
			// ��¼�ɹ�����user�������õ�HttpSession���÷�Χ��
			session.setAttribute("user", user);
            map.put("message", "��ӭ"+user.getUserName()+"��");
            map.put("url", "/Manage/main.jsp");
        } else {
            map.put("message", message != null ? "���ݿ�����ʧ�ܣ�" : "û������û���");
		    map.put("url", "/Manage/index.jsp");
		}
		return map;
	}
}
