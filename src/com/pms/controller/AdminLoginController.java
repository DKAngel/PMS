package com.pms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.pojo.Admin;
import com.pms.service.AdminLoginService;
import com.pms.utils.MD5;

@Controller
@RequestMapping(value = "/adminLogin")
public class AdminLoginController {
	
	@Resource(name = "adminLoginService")
	AdminLoginService adminLoginService;
	
	/**
	 * 后台登录界面
	 * @return login.jsp
	 */
	@RequestMapping(value = "index")
	public String index(){
		return "/admin/login";
	}
	
	/**
	 * 检查账号是否正确
	 * @param request
	 * @param session
	 * @return 
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	private String setAdmin (HttpServletRequest request, HttpSession session) {
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		if(account.equals("")){
			request.setAttribute("loginError", "账号不能为空!");
			return "/admin/login";
		}else{
			if(password.equals("")){
				request.setAttribute("loginError", "密码不能为空!");
				return "/admin/login";
			}
		}

        Admin admin = adminLoginService.getByAccount(account);
        if(admin == null){
        	request.setAttribute("loginError", "用户不存在!");
			return "/admin/login";
        }

        MD5 md5 = new MD5();
		String md5Password = md5.getMD5(password);

        if(md5Password.equals(admin.getAdminPassword())){
        	session.setAttribute("user", admin);
        	return "/admin/main";
        }else{
        	request.setAttribute("loginError", "密码不正确!");
			return "/admin/login";
        }
	}
}
