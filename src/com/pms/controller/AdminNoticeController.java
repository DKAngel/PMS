package com.pms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Admin;
import com.pms.pojo.Notice;
import com.pms.service.NoticeService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;

@Controller
@RequestMapping(value = "adminNotice")
public class AdminNoticeController {

	@Resource(name = "noticeService")
	NoticeService noticeService;
	
	/**
	 * 发布新公告
	 * @param request
	 * @param session
	 * @return noticeAdd.jsp
	 */
	@RequestMapping(value = "/addNotice", method = RequestMethod.POST)
	public String addNotice(HttpServletRequest request, HttpSession session){

		String str = request.getParameter("noticeTitle");
		CleanStyle cleanStyle = new CleanStyle();
		String noticeTitle = cleanStyle.cleanStyle(str);
		
		String noticeContent = request.getParameter("noticeContent");
		if(noticeTitle.equals("")){
        	request.setAttribute("noticeError", "标题不能为空!");
			return "/admin/noticeAdd";
        }
		if(noticeContent.equals("")){
        	request.setAttribute("noticeError", "内容不能为空!");
			return "/admin/noticeAdd";
        }
		
		GetNowTime getTime = new GetNowTime();
		Date noticeTime = getTime.getNowTime();
		
		Admin admin = (Admin)session.getAttribute("user");
		
		if(admin == null){
			return "redirect:/adminLogin/index";
		}
		
		int adminId =  admin.getAdminId();
		String adminName = admin.getAdminName();
		
		Notice notice = new Notice();
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		notice.setNoticeTime(noticeTime);
		notice.setAdminId(adminId);
		notice.setAdminName(adminName);
		
		int flag = noticeService.insertByNoId(notice);
		
		if(flag == 1){
			System.out.println("发布成功！");
			return "/admin/noticeAdd";
		}else{
			System.out.println("发布失败！");
			return "/admin/noticeAdd";
		}
	}
	
	/**
	 * 获取所有公告
	 * @return noticeSearch.jsp
	 */
	@RequestMapping(value = "getAllNotice")
	public ModelAndView getAllNotice(){
		ModelAndView noticeMV = new ModelAndView();  
        List<Notice> noticeList = noticeService.getAllNotice();
        
        noticeMV.addObject("noticeList",noticeList);  
        noticeMV.setViewName("/admin/noticeSearch");  
        return noticeMV;
	}
	
	/**
	 * 公告详情
	 * @param noticeId 公告ID
	 * @return noticeShowAndDelete.jsp
	 */
	@RequestMapping("/showNotice/{noticeId}")
	public ModelAndView showNoticeById(@PathVariable String noticeId) {
		
		Notice notice = noticeService.getByPrimaryKey(Integer.valueOf(noticeId));
		
		if(notice != null){
			ModelAndView noticeMV = new ModelAndView();  
			noticeMV.addObject("notice", notice);  
	        noticeMV.setViewName("/admin/noticeShowAndDelete");  
	        return noticeMV;
		}else{
			return null;
		}
	}
	
	@RequestMapping("/deleteNotice/{noticeId}")
	public String deleteNoticeById(@PathVariable String noticeId) {
		
		int deleteNotice = noticeService.deleteByPrimaryKey(Integer.valueOf(noticeId));
		
		if(deleteNotice == 1){
			System.out.println("删除成功！");
			return "redirect:/adminNotice/getAllNotice";  
		}else{
			return null;
		}
	}
}
