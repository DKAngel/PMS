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
	
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session){
		Owner owner = (Owner)session.getAttribute("owner");
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("name", owner.getOwnersName());
		mView.addObject("phone", owner.getOwnersPhone());
		mView.setViewName("/front/setInfo");
		
		return mView;
	}
	
	/**
	 * 修改资料
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/handle", method = RequestMethod.POST)
	public String handle(HttpServletRequest request, HttpSession session){
		
		CleanStyle cleanStyle = new CleanStyle();
		
		String name = cleanStyle.cleanStyle(request.getParameter("name"));
		
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		
		Owner oldOwner = (Owner)request.getSession().getAttribute("owner");
		
		ownerService.updateInfoByEmail(name, sex, phone, oldOwner.getOwnersEmail());
		
		Owner newOwner = ownerService.selectByEmail(oldOwner.getOwnersEmail());
		
		//刷新owner
		session.setAttribute("owner", newOwner);
		
		return "redirect:/frontLogin/index";
	}
}
