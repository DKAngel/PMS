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
import com.pms.pojo.Room;
import com.pms.service.EmailCodeService;
import com.pms.service.FrontRegisterService;
import com.pms.service.OwnerService;
import com.pms.service.RoomService;
import com.pms.utils.MD5;
import com.pms.utils.SendMail;

@Controller
@RequestMapping(value = "/frontRegister")
public class FrontRegisterController {
	
	@Resource(name = "frontRegisterService")
	FrontRegisterService frontRegisterService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	@Resource(name = "emailCodeService")
	EmailCodeService emailCodeService;
	
	@Autowired
	SendMail sendMail;
	
	/**
	 * 跳转到注册页面
	 * @return register.jsp
	 */
	@RequestMapping("/register")
	public String register(){
		return "/front/register";
	}
	
	/**
	 * 发送注册验证码
	 * @param request
	 * @return register.jsp
	 */
	@RequestMapping("/registerCode")
	public ModelAndView forget(HttpServletRequest request){
		
		String email = request.getParameter("email");
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("registerEmail", email);
		mView.setViewName("/front/register");
		
		Owner owner = ownerService.selectByEmail(email);
		if(owner != null){
        	request.setAttribute("loginError", "该邮箱已经注册");
			return mView;
        }
		
		StringBuffer code = new StringBuffer();
		Random random = new Random();
		for (int i=0; i<6; i++) {
			code.append(random.nextInt(10));
		}
		
		//发送邮件
		try {
			sendMail.sendCode(email, code.toString());
		} catch (Exception e) {
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
	 * 注册新用户
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public ModelAndView setOwner (HttpServletRequest request, HttpSession session){
		String registerEmail = request.getParameter("email");
		String registerPassword = request.getParameter("password");
		int registerRoomId = Integer.valueOf(request.getParameter("roomId"));
		String inputCode = request.getParameter("code");
		
		Owner existOwner = frontRegisterService.getByEmail(registerEmail);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("registerEmail", registerEmail);
		mView.addObject("registerPassword", registerPassword);
		mView.addObject("registerRoomId", registerRoomId);
		mView.setViewName("/front/register");
		
		if(existOwner != null){
			request.setAttribute("loginError", "该邮箱已注册");
			return mView;
		}
		
		//判读验证码是否相同
		EmailCode emailCode = emailCodeService.getByEmail(registerEmail);
		String existCode = emailCode.getCodeNum();
		if(!inputCode.equals(existCode)){
			request.setAttribute("loginError", "验证码不正确");
			return mView;
		}
		//判断是否存在单元房是否存在
		Room existRoom = roomService.getByPrimaryKey(registerRoomId);
		if(existRoom != null ){
			if(existRoom.getRoomOwner() == null){
				MD5 md5 = new MD5();
				String registerPasswordMD5 = md5.getMD5(registerPassword);
				
				Owner owner = new Owner();
				owner.setOwnersEmail(registerEmail);
				owner.setOwnersPassword(registerPasswordMD5);
				owner.setRoomId(registerRoomId);
				
				//增加新业主
				ownerService.insertByRegister(owner);
				
				//修改room房主id
				Owner roomOwner = ownerService.selectByEmail(registerEmail);
				if(roomOwner == null){
					System.out.println("FrontRegisterController.setOwner()"+"速度太快了");
				}else{
					int ownerId = roomOwner.getOwnersId();
					roomService.updateByRegister(ownerId, registerRoomId);
				}
				
				session.setAttribute("owner", owner);
				
				mView.setViewName("/front/index");
				return mView;
				
			}else{
				request.setAttribute("loginError", "该房间已被注册，如有疑问请联系管理员");
				return mView;
			}
		}else{
			request.setAttribute("loginError", "房间不存在");
			return mView;
		}
	}
}

