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

import com.pms.pojo.Activity;
import com.pms.pojo.Chat;
import com.pms.pojo.Complain;
import com.pms.pojo.Notice;
import com.pms.pojo.NumOfOwner;
import com.pms.pojo.Owner;
import com.pms.pojo.Room;
import com.pms.pojo.Suggest;
import com.pms.pojo.Upkeep;
import com.pms.service.ActivityService;
import com.pms.service.ChatService;
import com.pms.service.ComplainService;
import com.pms.service.NoticeService;
import com.pms.service.RoomService;
import com.pms.service.SuggestService;
import com.pms.service.UpkeepService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;

@Controller
@RequestMapping(value = "/frontIndex")
public class FrontIndexController {
	
	@Resource(name = "noticeService")
	NoticeService noticeService;
	
	@Resource(name = "complainService")
	ComplainService complainService;
	
	@Resource(name = "upkeepService")
	UpkeepService upkeepService;
	
	@Resource(name = "suggestService")
	SuggestService suggestService;
	
	@Resource(name = "chatService")
	ChatService chatService;
	
	@Resource(name = "activityService")
	ActivityService activityService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	/**
	 * 展示所有公告
	 * @return showNotice.jsp
	 */
	@RequestMapping(value = "/showNotice")
	public ModelAndView showNotice(){
		ModelAndView mView = new ModelAndView();  
        List<Notice> noticeList = noticeService.getAllNotice();
		mView.addObject("noticeList", noticeList);
		mView.setViewName("/front/showNotice");  
        return mView;
	}
	
	/**
	 * 公告详情
	 * @param noticeId 公告ID
	 * @return noticeDetail.jsp
	 */
	@RequestMapping("/noticeDetail/{noticeId}")
	public ModelAndView noticeDetail(@PathVariable String noticeId) {
		Notice notice = noticeService.getByPrimaryKey(Integer.valueOf(noticeId));
		ModelAndView mView = new ModelAndView();  
		mView.addObject("notice", notice);  
		mView.setViewName("/front/noticeDetail");  
        return mView;
	}
	
	/**
	 * 跳转到投诉界面
	 * @return complain.jsp
	 */
	@RequestMapping("/complain")
	public String complain(){
		return "/front/complain";
	}
	
	/**
	 * 投诉处理，添加投诉
	 * @param request
	 * @param session
	 * @return complain.jsp
	 */
	@RequestMapping(value = "/complainHandle", method = RequestMethod.POST)
	public String complainHandle(HttpServletRequest request, HttpSession session){
		String str = request.getParameter("textarea");
		CleanStyle cleanStyle = new CleanStyle();
		String content = cleanStyle.cleanStyle(str);
		
		String type = request.getParameter("select");
		
		if(content.equals("")){
			return "/front/complain";
		}

		GetNowTime getNowTime = new GetNowTime();
		Date time = getNowTime.getNowTime();
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();
		Complain complain = new Complain();
		complain.setComplainType(type);
		complain.setComplainContent(content);
		complain.setComplainTime(time);
		complain.setOwnersId(ownerId);
		
		int flag = complainService.insertByOwner(complain);
		
		if(flag > 0){
			System.out.println("投诉成功");
		}else{
			System.out.println("投诉失败");
		}
		return "/front/complain";
	}
	
	/**
	 * 跳转到建议界面
	 * @return suggest.jsp
	 */
	@RequestMapping("/suggest")
	public String suggest(){
		return "/front/suggest";
	}
	
	/**
	 * 处理建议，添加建议
	 * @param request
	 * @param session
	 * @return suggest.jsp
	 */
	@RequestMapping(value = "/suggestHandle", method = RequestMethod.POST)
	public String suggestHandle(HttpServletRequest request, HttpSession session){
		String str = request.getParameter("textarea");
		CleanStyle cleanStyle = new CleanStyle();
		String content = cleanStyle.cleanStyle(str);
		
		if(content.equals("")){
			return "/front/suggest";
		}
		
		GetNowTime getNowTime = new GetNowTime();
		Date time = getNowTime.getNowTime();
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();

		Suggest suggest = new Suggest();
		suggest.setSuggestContent(content);
		suggest.setSuggestTime(time);
		suggest.setOwnersId(ownerId);
		int flag = suggestService.insertByOwner(suggest);
		if(flag > 0){
			System.out.println("提交建议成功");
		}else{
			System.out.println("提交建议失败");
		}
		return "/front/suggest";
	}
	
	/**
	 * 跳转到报修页面
	 * @return upkeep.jsp
	 */
	@RequestMapping("/upkeep")
	public String upkeep(){
		return "/front/upkeep";
	}
	
	/**
	 * 处理报修，添加报修记录
	 * @param request
	 * @param session
	 * @return upkeep.jsp
	 */
	@RequestMapping(value = "/upkeepHandle", method = RequestMethod.POST)
	public String upkeepHandle(HttpServletRequest request, HttpSession session){
		String str = request.getParameter("textarea");
		CleanStyle cleanStyle = new CleanStyle();
		String content = cleanStyle.cleanStyle(str);

		if(content.equals("")){
			return "/front/upkeep";
		}

		String type = request.getParameter("select1")+request.getParameter("select2");

		GetNowTime getNowTime = new GetNowTime();
		Date time = getNowTime.getNowTime();
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();
		
		Upkeep upkeep = new Upkeep();
		upkeep.setUpkeepType(type);
		upkeep.setUpkeepContent(content);
		upkeep.setUpkeepTime(time);
		upkeep.setOwnersId(ownerId);
		
		int flag = upkeepService.insertByOwner(upkeep);
		
		if(flag > 0){
			System.out.println("报修成功");
		}else{
			System.out.println("报修失败");
		}
		return "/front/upkeep";
	}
	
	/**
	 * 聊天室
	 * @return chat.jsp
	 */
	@RequestMapping("/chat")
	public ModelAndView chat(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/chat");
		
		List<Chat> chats = chatService.getAllChat();
		
		mView.addObject("chatList", chats);
		mView.addObject("numOfOwner", NumOfOwner.numOfOwner);
		return mView;
	}
	
	/**
	 * 跳转到活动界面
	 * @return activity.jsp
	 */
	@RequestMapping("/activity")
	public ModelAndView activity(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/activity");
		
		List<Activity> activityList = activityService.getAllActivityBy1();
		
		mView.addObject("activityList", activityList);
		
		return mView;
	}
	
	/**
	 * 计算价格并跳转到支付页面
	 * @param session
	 * @return pay.jsp
	 */
	@RequestMapping("/payByWeiChat")
	public ModelAndView payByWeiChat(HttpSession session){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/pay");
		
		Owner owner = (Owner) session.getAttribute("owner");
		int roomId = owner.getRoomId();
		mView.addObject("roomId", roomId);
		
		Room room = roomService.getByPrimaryKey(roomId);
		
		int roomSize = room.getRoomSize();
		mView.addObject("roomSize", roomSize);
		
		double cost = room.getRoomSize() * 1.5;
		mView.addObject("cost", cost);
		
		return mView;
	}
	
	@RequestMapping("/payByAlipay")
	public String payByAlipay(){
		return "redirect:/frontIndex/payByWeiChat";
	}
	
	@RequestMapping("/payByBankCard")
	public String payByBankCard(){
		return "redirect:/frontIndex/payByWeiChat";
	}
	
	/**
	 * 投诉历史记录
	 * @return recordOfComplain
	 */
	@RequestMapping("/recordOfComplain")
	public ModelAndView recordOfComplain(HttpSession session){
		Owner owner = (Owner) session.getAttribute("owner");
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/recordOfComplain");
		List<Complain> complains = complainService.getAllComplainByOwner(owner.getOwnersId());
		
		for (Complain complain : complains) {
			String str = complain.getComplainContent();
			if(str.length() > 10){
				complain.setComplainContent(str.substring(0,9)+"......");
			}
			
			String result = complain.getComplainHandleResult();
			if(result == null){
				complain.setComplainHandleResult("暂未处理");
			}else{
				complain.setComplainHandleResult("查看处理详情");
			}
		}
		
		mView.addObject("complainList", complains);
		return mView;
	}
	
	/**
	 * 建议历史记录
	 * @return recordOfSuggest
	 */
	@RequestMapping("/recordOfSuggest")
	public ModelAndView recordOfSuggest(HttpSession session){
		Owner owner = (Owner) session.getAttribute("owner");
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/recordOfSuggest");
		List<Suggest> suggests = suggestService.getAllSuggestByOwner(owner.getOwnersId());
		
		for (Suggest suggest : suggests) {
			String str = suggest.getSuggestContent();
			if(str.length() > 10){
				suggest.setSuggestContent(str.substring(0,9)+"......");
			}
			
			String result = suggest.getSuggestHandleResult();
			if(result == null){
				suggest.setSuggestHandleResult("暂未处理");
			}else{
				suggest.setSuggestHandleResult("查看处理详情");
			}
		}
		
		mView.addObject("suggestList", suggests);
		return mView;
	}
	
	@RequestMapping("/recordOfPay")
	public String recordOfPay(){
		return "/front/recordOfPay";
	}
	
	/**
	 * 维修记录
	 * @return recordOfUpkeep.jsp
	 */
	@RequestMapping("/recordOfUpkeep")
	public ModelAndView recordOfUpkeep(HttpSession session){
		Owner owner = (Owner) session.getAttribute("owner");
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/recordOfUpkeep");
		List<Upkeep> upkeeps = upkeepService.getAllUpkeepByOwner(owner.getOwnersId());
		
		for (Upkeep upkeep: upkeeps) {
			String str = upkeep.getUpkeepContent();
			if(str.length() > 10){
				upkeep.setUpkeepContent(str.substring(0,9)+"......");
			}
			
			String result = upkeep.getUpkeepResult();
			if(result == null){
				upkeep.setUpkeepResult("暂未处理");
			}else{
				upkeep.setUpkeepResult("查看处理详情");
			}
		}
		
		mView.addObject("upkeepList", upkeeps);
		return mView;
	}
	
	@RequestMapping("/recordOfActivity")
	public ModelAndView recordOfActivity(HttpSession session){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/recordOfActivity");
		
		Owner owner = (Owner) session.getAttribute("owner");
		
		List<Activity> activityList = activityService.getAllActivityByOwnerId(owner.getOwnersId());
		
		mView.addObject("activityList", activityList);
		
		return mView;
	}
	
	/**
	 * 聊天记录
	 * @param session
	 * @return recordOfChat.jsp
	 */
	@RequestMapping("/recordOfChat")
	public ModelAndView recordOfChat(HttpSession session){
		
		Owner owner = (Owner) session.getAttribute("owner");
		
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/recordOfChat");
		List<Chat> chats = chatService.getAllChatByOwnerId(owner.getOwnersId());
		
		for (Chat chat: chats) {
			String str = chat.getChatContent();
			if(str.length() > 10){
				chat.setChatContent(str.substring(0,9)+"......");
			}
		}
		
		mView.addObject("chatList", chats);
		return mView;
	}
}
