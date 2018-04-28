package com.pms.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Admin;
import com.pms.pojo.Chat;
import com.pms.pojo.Complain;
import com.pms.pojo.Owner;
import com.pms.pojo.Suggest;
import com.pms.pojo.Upkeep;
import com.pms.service.AdminService;
import com.pms.service.ChatService;
import com.pms.service.ComplainService;
import com.pms.service.OwnerService;
import com.pms.service.SuggestService;
import com.pms.service.UpkeepService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;

@Controller
@RequestMapping(value = "/adminHandle")
public class AdminHandleController {
	
	@Resource(name = "complainService")
	ComplainService complainService;
	
	@Resource(name = "adminService")
	AdminService adminService;
	
	@Resource(name = "ownerService")
	OwnerService ownerService;
	
	@Resource(name = "suggestService")
	SuggestService suggestService;
	
	@Resource(name = "upkeepService")
	UpkeepService upkeepService;
	
	@Resource(name = "chatService")
	ChatService chatService;
	
	/**
	 * 删除投诉记录
	 * @param complainId
	 * @return  Controller
	 */
	@RequestMapping("/deleteComplain/{complainId}")
	public String deleteComplain(@PathVariable String complainId){
		
		int deleteComplain = complainService.deleteByComplainId(Integer.valueOf(complainId));
		
		if(deleteComplain == 1){
			System.out.println("删除成功！");
			return "redirect:/adminMain/complain";  
		}else{
			return null;
		}
	}
	
	/**
	 * 处理投诉
	 * @param complainId
	 * @return complain Controller
	 */
	@RequestMapping("/handleComplain/{complainId}")
	public ModelAndView handleComplain(@PathVariable String complainId){
		ModelAndView mView = new ModelAndView();
		
		Complain complain = complainService.getByComplainId(Integer.valueOf(complainId));
		
		Owner owner = ownerService.getByOwnerId(complain.getOwnersId());
		mView.addObject("complainOwner", owner);
		
		if(complain.getAdminId() != null){
			int adminId = Integer.valueOf(complain.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			complain.setComplainHandleResult("暂未处理");
		}
		
		mView.addObject("complain", complain);
		mView.setViewName("/admin/handleComplain");  
		
		return mView;
	}
	
	/**
	 * 更新投诉记录
	 * @param complainId
	 * @param session
	 * @param request
	 * @return complain Controller
	 */
	@RequestMapping("/updateComplain/{complainId}")
	public String updateComplain(@PathVariable String complainId, HttpSession session, HttpServletRequest request){
		Admin admin = (Admin) session.getAttribute("user");
		int adminId = admin.getAdminId();
		
		GetNowTime getNowTime = new GetNowTime();
		Date nowTime = getNowTime.getNowTime();
		
		CleanStyle cleanStyle = new CleanStyle();
		String result = cleanStyle.cleanStyle(request.getParameter("complainResult"));
		
		Complain complain = new Complain();
		complain.setAdminId(adminId);
		complain.setComplainHandleResult(result);
		complain.setComplainHandleTime(nowTime);
		complain.setComplainId(Integer.valueOf(complainId));
		
		int flag = complainService.updateByAdmin(complain);
		if(flag > 0){
			System.out.println("投诉处理成功");
		}
		return "redirect:/adminMain/complain";
	}
	
	/**
	 * 删除建议记录
	 * @param suggestId
	 * @return suggest Controller
	 */
	@RequestMapping("/deleteSuggest/{suggestId}")
	public String deleteSuggest(@PathVariable String suggestId){
		
		int deleteSuggest = suggestService.deleteBySuggestId(Integer.valueOf(suggestId));
		
		if(deleteSuggest == 1){
			System.out.println("删除成功！");
			return "redirect:/adminMain/suggest";  
		}else{
			return null;
		}
	}
	
	/**
	 * 处理建议
	 * @param suggestId
	 * @return handleSuggest.jsp
	 */
	@RequestMapping("/handleSuggest/{suggestId}")
	public ModelAndView handleSuggest(@PathVariable String suggestId){
		ModelAndView mView = new ModelAndView();
		
		Suggest suggest = suggestService.getBySuggestId(Integer.valueOf(suggestId));
		
		Owner owner = ownerService.getByOwnerId(suggest.getOwnersId());
		mView.addObject("suggestOwner", owner);
		
		if(suggest.getAdminId() != null){
			int adminId = Integer.valueOf(suggest.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			suggest.setSuggestHandleResult("暂未处理");
		}
		
		mView.addObject("suggest", suggest);
		mView.setViewName("/admin/handleSuggest");  
		
		return mView;
	}
	
	/**
	 * 更新建议处理
	 * @param suggestId
	 * @param session
	 * @param request
	 * @return suggest Controller
	 */
	@RequestMapping("/updateSuggest/{suggestId}")
	public String updateSuggest(@PathVariable String suggestId, HttpSession session, HttpServletRequest request){
		Admin admin = (Admin) session.getAttribute("user");
		int adminId = admin.getAdminId();
		
		GetNowTime getNowTime = new GetNowTime();
		Date nowTime = getNowTime.getNowTime();
		
		CleanStyle cleanStyle = new CleanStyle();
		String result = cleanStyle.cleanStyle(request.getParameter("suggestResult"));
		
		Suggest suggest = new Suggest();
		suggest.setAdminId(adminId);
		suggest.setSuggestHandleResult(result);
		suggest.setSuggestHandleTime(nowTime);
		suggest.setSuggestId(Integer.valueOf(suggestId));
		
		int flag = suggestService.updateByAdmin(suggest);

		if(flag > 0){
			System.out.println("建议处理成功");
		}
		return "redirect:/adminMain/suggest";
	}
	
	/**
	 * 删除维修记录
	 * @param upkeepId
	 * @return upkeep Controller
	 */
	@RequestMapping("/deleteUpkeep/{upkeepId}")
	public String deleteUpkeep(@PathVariable String upkeepId){
		
		int deleteUpkeep = upkeepService.deleteByUpkeepId(Integer.valueOf(upkeepId));
		
		if(deleteUpkeep == 1){
			System.out.println("删除成功！");
			return "redirect:/adminMain/upkeep";  
		}else{
			return null;
		}
	}
	
	/**
	 * 处理维修记录
	 * @param upkeepId
	 * @return handleUpkeep.jsp
	 */
	@RequestMapping("/handleUpkeep/{upkeepId}")
	public ModelAndView handleUpkeep(@PathVariable String upkeepId){
		ModelAndView mView = new ModelAndView();
		
		Upkeep upkeep = upkeepService.getByUpkeepId(Integer.valueOf(upkeepId));
		
		Owner owner = ownerService.getByOwnerId(upkeep.getOwnersId());
		mView.addObject("upkeepOwner", owner);
		
		if(upkeep.getAdminId() != null){
			int adminId = Integer.valueOf(upkeep.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			upkeep.setUpkeepProcess("暂未处理");
			upkeep.setUpkeepResult("暂未处理");
		}
		
		mView.addObject("upkeep", upkeep);
		mView.setViewName("/admin/handleUpkeep");  
		
		return mView;
	}
	
	/**
	 * 更新维修记录
	 * @param upkeepId
	 * @param session
	 * @param request
	 * @return upkeep Controller
	 */
	@RequestMapping("/updateUpkeep/{upkeepId}")
	public String updateUpkeep(@PathVariable String upkeepId, HttpSession session, HttpServletRequest request){
		Admin admin = (Admin) session.getAttribute("user");
		int adminId = admin.getAdminId();
		
		GetNowTime getNowTime = new GetNowTime();
		Date nowTime = getNowTime.getNowTime();
		
		CleanStyle cleanStyle = new CleanStyle();
		String process = cleanStyle.cleanStyle(request.getParameter("upkeepProcess"));
		String result = cleanStyle.cleanStyle(request.getParameter("upkeepResult"));
		
		Upkeep upkeep = new Upkeep();
		upkeep.setAdminId(adminId);
		upkeep.setUpkeepProcess(process);
		upkeep.setUpkeepResult(result);
		upkeep.setUpkeepHandleTime(nowTime);
		upkeep.setUpkeepId(Integer.valueOf(upkeepId));
		
		int flag = upkeepService.updateByAdmin(upkeep);
		if(flag > 0){
			System.out.println("维修处理成功");
		}
		return "redirect:/adminMain/upkeep";
	}
	
	/**
	 * 删除聊天记录
	 * @param chatId
	 * @return chat.jsp
	 */
	@RequestMapping("/deleteChat/{chatId}")
	public String deleteChat(@PathVariable String chatId){
		
		int deleteChat = chatService.deleteByChatId(Integer.valueOf(chatId));
		
		if(deleteChat == 1){
			System.out.println("删除成功！");
			return "redirect:/adminMain/chat";  
		}else{
			return null;
		}
	}
	
	/**
	 * 聊天记录（查看）
	 * @param chatId
	 * @return handleChat.jsp
	 */
	@RequestMapping("/handleChat/{chatId}")
	public ModelAndView handleChat(@PathVariable String chatId){
		ModelAndView mView = new ModelAndView();
		
		Chat chat = chatService.getByChatId(Integer.valueOf(chatId));
		mView.addObject("chat", chat);
		
		Owner owner = ownerService.getByOwnerId(chat.getOwnersId());
		mView.addObject("chatOwner", owner);
		
		mView.setViewName("/admin/handleChat");  
		
		return mView;
	}
}
