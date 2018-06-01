package com.pms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Owner;
import com.pms.service.OwnerService;
import com.pms.utils.CleanStyle;

@Controller
@RequestMapping(value = "/frontSetInfo")
public class FrontSetInfoController {
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	/**
	 * 资料设置
	 * @param session
	 * @return setInfo.jsp
	 */
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session){
		
		ModelAndView mView = new ModelAndView();
		
		Owner owner = (Owner)session.getAttribute("owner");
		if(owner == null){
			mView.setViewName("/front/login");
			return mView;
		}
		
		mView.addObject("name", owner.getOwnersName());
		mView.addObject("phone", owner.getOwnersPhone());
		mView.addObject("ownerSex", owner.getOwnersSex());
		mView.setViewName("/front/setInfo");
		
		return mView;
	}
	
	/**
	 * 修改资料
	 * @param request
	 * @return true: index.jsp false:login.jsp/setInfo.jsp
	 */
	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public ModelAndView handle(HttpServletRequest request, HttpSession session){
		ModelAndView mView = new ModelAndView();
		CleanStyle cleanStyle = new CleanStyle();
		
		String name = cleanStyle.cleanStyle(request.getParameter("name"));
		if(name.length() > 50){
			request.setAttribute("setInfoError", "名字过长");
			System.out.println("名字过长");
			Owner owner = (Owner)session.getAttribute("owner");
			if(owner == null){
				mView.setViewName("/front/login");
				return mView;
			}
			mView.addObject("name", owner.getOwnersName());
			mView.addObject("phone", owner.getOwnersPhone());
			mView.setViewName("/front/setInfo");
			return mView;
		}
		
		String sex = cleanStyle.cleanStyle(request.getParameter("sex"));
		
		String phone = cleanStyle.cleanStyle(request.getParameter("phone"));
		
		Owner oldOwner = (Owner)request.getSession().getAttribute("owner");
		if(oldOwner == null){
			mView.setViewName("redirect:/frontLogin/login");
			return mView;
		}
		
		ownerService.updateInfoByEmail(name, sex, phone, oldOwner.getOwnersEmail());
		
		Owner newOwner = ownerService.selectByEmail(oldOwner.getOwnersEmail());
		
		//刷新owner
		session.setAttribute("owner", newOwner);
		
		mView.setViewName("redirect:/frontLogin/index");
		return mView;
	}
}
