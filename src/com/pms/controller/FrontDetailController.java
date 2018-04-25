package com.pms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Admin;
import com.pms.pojo.Complain;
import com.pms.pojo.Suggest;
import com.pms.pojo.Upkeep;
import com.pms.service.AdminService;
import com.pms.service.ComplainService;
import com.pms.service.SuggestService;
import com.pms.service.UpkeepService;

@Controller
@RequestMapping(value = "frontDetail")
public class FrontDetailController {
	
	@Resource(name = "complainService")
	ComplainService complainService;
	
	@Resource(name = "suggestService")
	SuggestService suggestService;
	
	@Resource(name = "adminService")
	AdminService adminService;
	
	@Resource(name = "upkeepService")
	UpkeepService upkeepService;
	
	/**
	 * 查看某条投诉记录
	 * @param complainId 记录ID
	 * @return complainDetail.jsp
	 */
	@RequestMapping("/showComplain/{complainId}")
	public ModelAndView showComplain(@PathVariable String complainId){
		ModelAndView mView = new ModelAndView();
		
		Complain complain = complainService.getByComplainId(Integer.valueOf(complainId));
		
		if(complain.getAdminId() != null){
			int adminId = Integer.valueOf(complain.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			complain.setComplainHandleResult("暂未处理");
		}
		
		mView.addObject("complain", complain);
		mView.setViewName("/front/complainDetail");  
        return mView;
	}
	
	/**
	 * 删除投诉记录
	 * @param complainId
	 * @return recordOfComplain Controller
	 */
	@RequestMapping("/deleteComplain/{complainId}")
	public String deleteComplain(@PathVariable String complainId){
		
		int deleteComplain = complainService.deleteByComplainId(Integer.valueOf(complainId));
		
		if(deleteComplain == 1){
			System.out.println("删除成功！");
			return "redirect:/frontIndex/recordOfComplain";  
		}else{
			return null;
		}
	}
	
	/**
	 * 查看某条建议记录
	 * @param suggestId
	 * @return suggestDetail.jsp
	 */
	@RequestMapping("/showSuggest/{suggestId}")
	public ModelAndView showSuggest(@PathVariable String suggestId){
		ModelAndView mView = new ModelAndView();
		
		Suggest suggest = suggestService.getBySuggestId(Integer.valueOf(suggestId));
		
		if(suggest.getAdminId() != null){
			int adminId = Integer.valueOf(suggest.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			suggest.setSuggestHandleResult("暂未处理");
		}
		
		mView.addObject("suggest", suggest);
		mView.setViewName("/front/suggestDetail");  
        return mView;
	}
	
	/**
	 * 删除建议记录
	 * @param suggestId
	 * @return recordOfSuggest Controller
	 */
	@RequestMapping("/deleteSuggest/{suggestId}")
	public String deleteSuggest(@PathVariable String suggestId){
		
		int deleteSuggest = suggestService.deleteBySuggestId(Integer.valueOf(suggestId));
		
		if(deleteSuggest == 1){
			System.out.println("删除成功！");
			return "redirect:/frontIndex/recordOfSuggest";  
		}else{
			System.out.println("删除失败");
			return null;
		}
	}
	
	@RequestMapping("/showUpkeep/{upkeepId}")
	public ModelAndView showUpkeep(@PathVariable String upkeepId){
		ModelAndView mView = new ModelAndView();
		
		Upkeep upkeep = upkeepService.getByUpkeepId(Integer.valueOf(upkeepId));
		
		if(upkeep.getAdminId() != null){
			int adminId = Integer.valueOf(upkeep.getAdminId());
			Admin admin = adminService.getByAdminId(adminId);
			mView.addObject("adminName", admin.getAdminName());
		}else{
			upkeep.setUpkeepResult("暂未处理");
		}
		
		mView.addObject("upkeep", upkeep);
		mView.setViewName("/front/upkeepDetail");  
        return mView;
	}
	
	/**
	 * 删除某条维修记录
	 * @param upkeepId
	 * @return recordOfUpkeep Controller
	 */
	@RequestMapping("/deleteUpkeep/{upkeepId}")
	public String deleteUpkeep(@PathVariable String upkeepId){
		
		int deleteUpkeep = upkeepService.deleteByUpkeepId(Integer.valueOf(upkeepId));
		
		if(deleteUpkeep == 1){
			System.out.println("删除成功！");
			return "redirect:/frontIndex/recordOfUpkeep";  
		}else{
			return null;
		}
	}
	
}
