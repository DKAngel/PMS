package com.pms.controller;

import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.EmailCode;
import com.pms.pojo.Owner;
import com.pms.service.EmailCodeService;
import com.pms.service.OwnerService;
import com.pms.utils.MD5;
import com.pms.utils.SendMail;

@Controller
@RequestMapping(value = "/frontSetAccount")
public class FrontSetAccountController {
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	@Resource(name = "emailCodeService")
	EmailCodeService emailCodeService;
	
	@Autowired
	SendMail sendMail;
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session){
		ModelAndView mView = new ModelAndView();
		
		Owner oldOwner = (Owner)session.getAttribute("owner");
		if(oldOwner == null){
			mView.setViewName("/front/login");
			return mView;
		}
		
		String newEmail = oldOwner.getOwnersEmail();
		
		
		mView.addObject("newEmail", newEmail);
		mView.setViewName("/front/setAccount");
		return mView;
	}
	
	/**
	 * 账号设置：发送验证码
	 * @param request
	 * @param session
	 * @return setAccount.jsp
	 */
	@RequestMapping("/setAccountCode")
	public ModelAndView setAccountCode(HttpServletRequest request, HttpSession session){
		
		String newEmail = request.getParameter("email");

		ModelAndView mView = new ModelAndView();
		mView.addObject("newEmail", newEmail);
		mView.setViewName("/front/setAccount");
		
	    Owner oldOwner = (Owner)session.getAttribute("owner");
		if(!oldOwner.getOwnersEmail().equals(newEmail)){
			Owner newOwner = ownerService.selectByEmail(newEmail);
			if(newOwner != null){
	        	request.setAttribute("loginError", "该邮箱已经注册");
				return mView;
	        }
		}
		
		StringBuilder code = new StringBuilder();
		Random random = new Random();
		for (int i=0; i<6; i++) {
			code.append(random.nextInt(10));
		}
		
		//发送邮件
		try {
			sendMail.sendCode(newEmail, code.toString());
		} catch (Exception e) {
			request.setAttribute("loginError", "邮箱不存在");
			return mView;
		}
		
		EmailCode existCode = emailCodeService.getByEmail(newEmail);
		//插入验证码
		if(existCode == null){
			EmailCode emailCode = new EmailCode();
			emailCode.setOwnersEmail(newEmail);
			emailCode.setCodeNum(code.toString());
			emailCodeService.insertByNoId(emailCode);
		//更新验证码
		}else{
			emailCodeService.updateByEmail(code.toString(), newEmail);
		}
		return mView;
	}
	/**
	 * 修改账户信息
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public ModelAndView handle(HttpServletRequest request, HttpSession session){
		String newEmail = request.getParameter("email");
		String password = request.getParameter("password");
		String inputCode = request.getParameter("code");
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("newEmail", newEmail);
		mView.addObject("newPassword", password);
		mView.setViewName("/front/setAccount");
		
		//判读验证码是否相同
		EmailCode emailCode = emailCodeService.getByEmail(newEmail);
		String existCode = emailCode.getCodeNum();
		if(!inputCode.equals(existCode)){
			request.setAttribute("loginError", "验证码不正确");
			return mView;
		}
		
		Owner oldOwner = (Owner)session.getAttribute("owner");
		String oldEmail = oldOwner.getOwnersEmail();
		
		MD5 md5 = new MD5();
		String newPassword = md5.getMD5(password);
		
		ownerService.updateAccountByEmail(newEmail, newPassword, oldEmail);
		
		return mView;
	}
}
