package com.pms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Activity;
import com.pms.pojo.Chat;
import com.pms.pojo.Complain;
import com.pms.pojo.Pay;
import com.pms.pojo.Room;
import com.pms.pojo.Suggest;
import com.pms.pojo.Upkeep;
import com.pms.service.ActivityService;
import com.pms.service.ChatService;
import com.pms.service.ComplainService;
import com.pms.service.NoticeService;
import com.pms.service.PayService;
import com.pms.service.RoomService;
import com.pms.service.SuggestService;
import com.pms.service.UpkeepService;

@Controller
@RequestMapping(value = "/adminMain")
public class AdminMainController {
	
	@Resource(name = "noticeService")
	NoticeService noticeService;
	
	@Resource(name = "complainService")
	ComplainService complainService;
	
	@Resource(name = "suggestService")
	SuggestService suggestService;
	
	@Resource(name = "upkeepService")
	UpkeepService upkeepService;
	
	@Resource(name = "chatService")
	ChatService chatService;
	
	@Resource(name = "activityService")
	ActivityService activityService;
	
	@Resource(name = "payService")
	PayService payService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	@RequestMapping(value = "main")
	public String main(){
		return "/admin/main";
	}
	
	@RequestMapping(value = "top")
	public String top(){
		return "/admin/top";
	}
	@RequestMapping(value = "left")
	public String left(){
		return "/admin/left";
	}
	@RequestMapping(value = "index")
	public String index(){
		return "/admin/index";
	}
	
	@RequestMapping(value = "notice")
	public String notice(){
		return "/admin/noticeAdd";
	}
	
	/**
	 * 投诉管理
	 * @return complain.jsp
	 */
	@RequestMapping(value = "complain")
	public ModelAndView complain(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/complain");
		
		List<Complain> complainList = complainService.getAllComplain();
		
		for (Complain complain : complainList) {
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
		
		mView.addObject("complainList", complainList);
		
		return mView;
	}
	
	/**
	 * 建议管理
	 * @return suggest.jsp
	 */
	@RequestMapping(value = "suggest")
	public ModelAndView suggest(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/suggest");
		
		List<Suggest> suggestList = suggestService.getAllSuggest();
		
		for (Suggest suggest : suggestList) {
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
		
		mView.addObject("suggestList", suggestList);
		
		return mView;
	}
	
	/**
	 * 维修管理
	 * @return upkeep.jsp
	 */
	@RequestMapping(value = "upkeep")
	public ModelAndView upkeep(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/upkeep");
		
		List<Upkeep> upkeepList = upkeepService.getAllUpkeep();
		
		for(Upkeep upkeep : upkeepList){
			String str = upkeep.getUpkeepContent();
			if(str.length() > 10){
				upkeep.setUpkeepContent(str.substring(0,9)+"......");
			}
			
			String process = upkeep.getUpkeepProcess();
			if(process == null ){
				upkeep.setUpkeepProcess("暂未处理");
				upkeep.setUpkeepResult("暂未处理");
			}else{
				if(process.length() > 10){
					upkeep.setUpkeepProcess(process.substring(0,9)+"......");
				}
				String result = upkeep.getUpkeepResult();
				if(result == null || result.equals("")){
					upkeep.setUpkeepResult("正在处理,请耐心等待");
				}else{
					if(result.length() > 10){
						upkeep.setUpkeepResult("查看处理详情");
					}
				}
			}
		}
		mView.addObject("upkeepList", upkeepList);
		return mView;
	}
	
	/**
	 * 聊天管理
	 * @return chat.jsp
	 */
	@RequestMapping(value = "chat")
	public ModelAndView chat(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/chat");
		
		List<Chat> chatList = chatService.getAllChat();
		
		for (Chat chat : chatList) {
			String str = chat.getChatContent();
			if(str.length() > 10){
				chat.setChatContent(str.substring(0,9)+"......");
			}
		}
		
		mView.addObject("chatList", chatList);
		
		return mView;
	}
	
	/**
	 * 待审核活动查询
	 * @return activityVerify.jsp
	 */
	@RequestMapping(value = "activityVerify")
	public ModelAndView activityVerify(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/activityVerify");
		
		List<Activity> activityList = activityService.getAllActivityBy0();
		
		for (Activity activity : activityList) {
			String str = activity.getActivityContent();
			if(str.length() > 10){
				activity.setActivityContent(str.substring(0,9)+"......");
			}
		}
		
		mView.addObject("activityList", activityList);
		
		return mView;
	}
	
	/**
	 * 所有活动记录查询
	 * @return activity.jsp
	 */
	@RequestMapping(value = "activity")
	public ModelAndView activity(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/activity");
		
		List<Activity> activityList = activityService.getAllActivity();
		
		for (Activity activity : activityList) {
			String str = activity.getActivityContent();
			if(str.length() > 10){
				activity.setActivityContent(str.substring(0,9)+"......");
			}
		}
		
		mView.addObject("activityList", activityList);
		
		return mView;
	}
	
	/**
	 * 缴费历史记录查询
	 * @return payHistory.jsp
	 */
	@RequestMapping(value = "payHistory")
	public ModelAndView payHistory(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/payHistory");
		
		List<Pay> payList = payService.getAllPayByRoom();
		
		mView.addObject("payList", payList);
		
		return mView;
	}
	
	/**
	 * 单元房缴费情况
	 * @return payCurrentSituation.jsp
	 */
	@RequestMapping(value = "payCurrentSituation")
	public ModelAndView payCurrentSituation(){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/payCurrentSituation");
		
		List<Room> roomList = roomService.getAllRoomWithOwner();
		mView.addObject("roomList", roomList);
		
		return mView;
	}
	
}
