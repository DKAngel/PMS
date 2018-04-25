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
import com.pms.pojo.NumOfOwner;
import com.pms.pojo.Owner;
import com.pms.service.EmailCodeService;
import com.pms.service.FrontLoginService;
import com.pms.service.OwnerService;
import com.pms.utils.MD5;
import com.pms.utils.SendMail;

@Controller
@RequestMapping(value = "/frontLogin")
public class FrontLoginController {
	
	@Resource(name = "frontLoginService")
	FrontLoginService frontLoginService;
	
	@Resource(name = "emailCodeService")
	EmailCodeService emailCodeService;
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	@Autowired
	SendMail sendMail;
	
	/**
	 * 跳转到前台登录页面
	 * @return login.jsp
	 */
	@RequestMapping("/login")
	public String login(){
		return "/front/login";
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session){
		session.setAttribute("owner", null);
		if(NumOfOwner.numOfOwner > 0){
			NumOfOwner.numOfOwner--;
		}
		return "/front/login";
	}
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/index")
	public String index(){
		return "/front/index";
	}
	
	/**
	 * 检测业主信息是否存在，登录系统
	 * @param request
	 * @param session
	 * @return login.jsp 或 index.jsp
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ModelAndView check(HttpServletRequest request, HttpSession session){
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginEmail", email);
		mv.setViewName("/front/login");

		if(email.equals("")){
			request.setAttribute("loginError", "邮箱不能为空");
			return mv;
		}else{
			if(password.equals("")){
				request.setAttribute("loginError", "密码不能为空");
				return mv;
			}
		}
		Owner owner = frontLoginService.getByEmail(email);
		
		if(owner == null){
        	request.setAttribute("loginError", "业主不存在");
			return mv;
        }
		
		MD5 md5 = new MD5();
		String md5Password = md5.getMD5(password);
		
        if(md5Password.equals(owner.getOwnersPassword())){
        	
        	mv.setViewName("/front/index");
        	
        	Owner sessionOwner = (Owner) session.getAttribute("owner");
        	
        	//已经存在session
        	if(sessionOwner != null ){
        		String sessionEmail = sessionOwner.getOwnersEmail();
        		//重复登录
        		if(sessionEmail.equals(email)){
        			return mv;
        		}else{
        			mv.setViewName("/front/login");
            		request.setAttribute("loginError", "同一浏览器不能登录多个账号，请使用其他浏览器");
        			return mv;
        		}
        	//不存在session
        	}else{
        		session.setAttribute("owner", owner);
            	NumOfOwner.numOfOwner++;
            	System.out.println("登录成功，当前在线用户量："+NumOfOwner.numOfOwner);
            	return mv;
        	}
        }else{
        	request.setAttribute("loginError", "密码不正确");
			return mv;
        }
	}
	
	/**
	 * 跳转到忘记密码页面
	 * @return forget.jsp
	 */
	@RequestMapping(value = "/forget")
	public String forget(){
		return "/front/forget";
	}
	
	/**
	 * 发送验证码到邮箱，并将验证码存入数据库emailcode表中
	 * @param request
	 * @return forget.jsp
	 */
	@RequestMapping("/sendCode")
	public ModelAndView forget(HttpServletRequest request){
		
		String email = request.getParameter("email");
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("forgetEmail", email);
		mView.setViewName("/front/forget");
		
		Owner owner = frontLoginService.getByEmail(email);
		if(owner == null){
        	request.setAttribute("loginError", "该邮箱未注册");
			return mView;
        }
		
		StringBuilder code = new StringBuilder();
		
		Random random = new Random();
		for (int i=0; i<6; i++) {
			code.append(random.nextInt(10));
		}
		
		//发送邮件
		try {
			sendMail.sendCode(email, code.toString());
		} catch (Exception e) {
//			e.printStackTrace();
			request.setAttribute("loginError", "邮箱不存在");
			return mView;
		}
		
		EmailCode existCode = emailCodeService.getByEmail(email);
		//插入验证码
		if(existCode == null){
			EmailCode emailCode = new EmailCode();
			emailCode.setOwnersEmail(email);
			emailCode.setCodeNum(code.toString());
			emailCodeService.insertByNoId(emailCode);
		//更新验证码
		}else{
			emailCodeService.updateByEmail(code.toString(), email);
		}
		return mView;
	}
	
	/**
	 * 判断验证码是否正确、更新密码操作
	 * @param request
	 * @return true:login.jsp false:forget.jsp
	 */
	@RequestMapping(value = "/updatePWD", method = RequestMethod.POST)
	public ModelAndView updatePWD(HttpServletRequest request){
		String email = request.getParameter("email");
		String inputCode = request.getParameter("code");
		String password = request.getParameter("password");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("forgetEmail", email);
		mv.addObject("updatePassword", password);
		mv.setViewName("/front/forget");
		
		EmailCode emailCode = emailCodeService.getByEmail(email);
		String existCode = emailCode.getCodeNum();
		
		if(!inputCode.equals(existCode)){
			request.setAttribute("loginError", "验证码不正确");
			return mv;
		}
		
		Owner owner = frontLoginService.getByEmail(email);
		if(owner == null){
        	request.setAttribute("loginError", "业主不存在");
			return mv;
        }
		
		MD5 md5 = new MD5();
		String md5Password = md5.getMD5(password);
        
		ownerService.updatePasswordByEmail(md5Password, email);
		
		mv.setViewName("/front/login");
		return mv;
	}
}
