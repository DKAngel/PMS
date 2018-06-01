package com.pms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Activity;
import com.pms.pojo.Admin;
import com.pms.pojo.Chat;
import com.pms.pojo.Complain;
import com.pms.pojo.Joins;
import com.pms.pojo.Owner;
import com.pms.pojo.Pay;
import com.pms.pojo.Room;
import com.pms.pojo.Suggest;
import com.pms.pojo.Upkeep;
import com.pms.pojo.Verify;
import com.pms.service.ActivityService;
import com.pms.service.AdminService;
import com.pms.service.ChatService;
import com.pms.service.ComplainService;
import com.pms.service.JoinsService;
import com.pms.service.OwnerService;
import com.pms.service.PayService;
import com.pms.service.RoomService;
import com.pms.service.SuggestService;
import com.pms.service.UpkeepService;
import com.pms.service.VerifyService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;
import com.pms.utils.SendMail;

@Controller
@RequestMapping(value = "/adminHandle")
public class AdminHandleController {
	
	@Autowired
	SendMail sendMail;
	
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
	
	@Resource(name = "activityService")
	ActivityService activityService;
	
	@Resource(name = "verifyService")
	VerifyService verifyService;
	
	@Resource(name = "joinsService")
	JoinsService joinsService;
	
	@Resource(name = "payService")
	PayService payService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
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
		
		if(admin == null){
			return "redirect:/adminLogin/index";
		}
		
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
		
		if(admin == null){
			return "redirect:/adminLogin/index";
		}
		
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
		
		if(admin == null){
			return "redirect:/adminLogin/index";
		}
		
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
	
	/**
	 * 活动审核
	 * @param activityId
	 * @return
	 */
	@RequestMapping("/activityVerify/{activityId}")
	public ModelAndView activityVerify(@PathVariable String activityId){
		ModelAndView mView = new ModelAndView();
		
		Activity activity = activityService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("activity", activity);
		
		Owner owner = ownerService.getByOwnerId(activity.getOwnersId());
		mView.addObject("activityOwner", owner);
		
		mView.setViewName("/admin/activityVerifyDetail");  
		
		return mView;
	}
	
	/**
	 * 更新审核活动记录
	 * @param activityId
	 * @param session
	 * @param request
	 * @return activityVerify.jsp
	 */
	@RequestMapping("/updateActivity/{activityId}")
	public String updateActivity(@PathVariable String activityId, HttpSession session, HttpServletRequest request){
		Admin admin = (Admin) session.getAttribute("user");
		
		if(admin == null){
			return "redirect:/adminLogin/index";
		}
		
		int adminId = admin.getAdminId();
		
		GetNowTime getNowTime = new GetNowTime();
		Date nowTime = getNowTime.getNowTime();
		
		CleanStyle cleanStyle = new CleanStyle();
		String verifyContent = cleanStyle.cleanStyle(request.getParameter("verifyContent"));
		String verifyResult = request.getParameter("verifyResult");
		
		int state;
		if(verifyResult.equals("是")){
			state = 1;
		}else{
			state = 2;
		}
		
		Activity activity = new Activity();
		activity.setActivityId(Integer.valueOf(activityId));
		activity.setActivityState(state);
		
		activityService.updateStateById(activity);
		
		Verify verify = new Verify();
		verify.setActivityId(Integer.valueOf(activityId));
		verify.setVerifyContent(verifyContent);
		verify.setVerifyResult(verifyResult);
		verify.setVerifyTime(nowTime);
		verify.setAdminId(adminId);
		
		int flag = verifyService.insertByAdmin(verify);
		
		if(flag > 0){
			System.out.println("审核成功");
		}
		return "redirect:/adminMain/activityVerify";
	}
	
	/**
	 * 删除活动记录
	 * @param activityId
	 * @return activity Controller
	 */
	@RequestMapping("/deleteActivity/{activityId}")
	public String deleteActivity(@PathVariable String activityId){
		
		joinsService.deleteByActivityId(Integer.valueOf(activityId));
		
		verifyService.deleteByActivityId(Integer.valueOf(activityId));
		
		int deleteActivity = activityService.deleteByPrimaryKey(Integer.valueOf(activityId));
		
		if(deleteActivity == 1){
			System.out.println("删除成功！");
			return "redirect:/adminMain/activity";
		}else{
			return null;
		}
	}
	
	/**
	 * 活动详情
	 * @param activityId
	 * @return handleActivity
	 */
	@RequestMapping("/handleActivity/{activityId}")
	public ModelAndView handleActivity(@PathVariable String activityId){
		ModelAndView mView = new ModelAndView();
		
		Activity activity = activityService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("activity", activity);
		
		List<Joins> joinList = joinsService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("joinList", joinList);
		
		Verify verify = verifyService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("verify", verify);
		
		if(verify != null){
			Admin admin = adminService.getByAdminId(verify.getAdminId());
			mView.addObject("admin", admin);
		}
		
		mView.setViewName("/admin/handleActivity");  
		
		return mView;
	}
	
	/**
	 * 缴费详情
	 * @param payId
	 * @return handlePay.jsp
	 */
	@RequestMapping("/handlePay/{payId}")
	public ModelAndView handlePay(@PathVariable String payId){
		ModelAndView mView = new ModelAndView();
		
		Pay pay = payService.getPayByPayId(Integer.valueOf(payId));
		
		mView.addObject("pay", pay);
		
		mView.setViewName("/admin/handlePay");  
		
		return mView;
	}
	
	/**
	 * 单元房详细缴费信息
	 * @param roomId
	 * @param request
	 * @return handlePayOfRoom.jsp
	 */
	@RequestMapping("/handlePayOfRoom/{roomId}")
	public ModelAndView handlePayOfRoom(@PathVariable String roomId, HttpServletRequest request){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/handlePayOfRoom");
		
		Room room = roomService.getAllRoomWithOwnerAndPay(Integer.valueOf(roomId));
		mView.addObject("room", room);
		try{
			//有业主并且缴过费
			if(room.getPay() != null){
				Date payTime = room.getPay().getPayTime();
				Date deadLine = new Date(payTime.getTime()+30*24*60*60*1000L);
				Date nowTime = new GetNowTime().getNowTime();
				if(deadLine.after(nowTime)){
					request.setAttribute("payError", "正常缴纳物业费");
					mView.addObject("deadLine", deadLine);
				}else{
					int days = (int) ((nowTime.getTime() - deadLine.getTime())/(1000 * 60 * 60 * 24));
					request.setAttribute("payError", "业主已拖欠物业费");
					mView.addObject("days", days+"天");
				}
			}
		}catch (Exception e){
			Room room2 = roomService.getRoomAndOwnerById(Integer.valueOf(roomId));
			try{
				//有业主，但是没缴过费
				if( room2.getOwner() != null){
					request.setAttribute("payError", "业主未缴纳过物业费");
					mView.addObject("room", room2);
				}
			}catch(Exception e1){
				//无业主
				Room room3 = roomService.getByRoomId(Integer.valueOf(roomId));
				request.setAttribute("payError", "暂时未有业主入住");
				mView.addObject("room", room3);
			}
		}
		return mView;
	}
	
	/**
	 * 删除业主
	 * @param oId String类型的 业主ID
	 * @return manageOwner Controller
	 */
	@RequestMapping("/deleteOwner/{oId}")
	public String deleteOwner(@PathVariable String oId){
		
		int ownerId = Integer.valueOf(oId);
		
		int complain = complainService.deleteByOwnerId(ownerId);
		if(complain > 0){
			System.out.println("投诉表删除成功");
		}
		
		int suggest = suggestService.deleteByOwnerId(ownerId);
		if(suggest > 0){
			System.out.println("建议表删除成功");
		}
		
		int upkeep = upkeepService.deleteByOwnerId(ownerId);
		if(upkeep > 0){
			System.out.println("报修表删除成功");
		}
		
		int chat = chatService.deleteByOwnerId(ownerId);
		if(chat > 0){
			System.out.println("聊天表删除成功");
		}
		
		int join = joinsService.deleteByOwnerId(ownerId);
		if(join > 0){
			System.out.println("参与表删除成功");
		}
		
		int verify = verifyService.deleteByActivityOwner(ownerId);
		if(verify > 0){
			System.out.println("审核表删除成功");
		}
		
		int activity = activityService.deleteByOwnerId(ownerId);
		if(activity > 0){
			System.out.println("活动表删除成功");
		}
		
		int pay = payService.deleteByOwnerId(ownerId);
		if(pay > 0){
			System.out.println("缴费表删除成功");
		}
		
		int room = roomService.updateRoomOwnerByOwnerId(ownerId);
		if(room > 0){
			System.out.println("单元房房主修改成功");
		}
		
		int owners = ownerService.deleteByPrimaryKey(ownerId);
		if(owners > 0){
			System.out.println("业主删除成功");
			return "redirect:/adminMain/manageOwner";
		}
		
		return null;
	}
	
	/**
	 * 修改业主信息
	 * @param ownerId
	 * @return updateOwner.jsp
	 */
	@RequestMapping("/updateOwner/{ownerId}")
	public ModelAndView updateOwner(@PathVariable String ownerId){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/updateOwner");
		
		Owner owner = ownerService.getByOwnerId(Integer.valueOf(ownerId));
		
		mView.addObject("owner", owner);
		
		return mView;
	}
	
	/**
	 * 确认修改业主信息
	 * @param ownerId
	 * @param request
	 * @return manageOwner Controller
	 */
	@RequestMapping("/submitUpdateOwner/{ownerId}")
	public String submitUpdateOwner(@PathVariable String ownerId, HttpServletRequest request){
		CleanStyle cleanStyle = new CleanStyle();
		String name = cleanStyle.cleanStyle(request.getParameter("name"));
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		
		Owner newOwner = new Owner();
		newOwner.setOwnersId(Integer.valueOf(ownerId));
		newOwner.setOwnersName(name);
		newOwner.setOwnersSex(sex);
		newOwner.setOwnersPhone(phone);
		
		ownerService.updateInfoByOwnerId(newOwner);
		
		return "redirect:/adminMain/manageOwner";
	}
	
	/**
	 * 提醒业主缴费：即发送邮件
	 * @param ownerId
	 * @param session
	 * @param request
	 * @return handleOverRoom.jsp
	 */
	@RequestMapping("/handleOverRoom/{ownerId}")
	public ModelAndView handleOverRoom(@PathVariable String ownerId, HttpSession session, HttpServletRequest request){
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/admin/overOwnerRemind");
		mView.addObject("overRoomList", session.getAttribute("overRoomList"));
		
		Owner owner = ownerService.getByOwnerId(Integer.valueOf(ownerId));
		
		try {
			sendMail.sendCode(owner.getOwnersEmail(), "请按时缴纳物业费，谢谢合作，祝您生活愉快！");
		} catch (Exception e) {
			request.setAttribute("sendError", "邮箱不存在");
			return mView;
		}
		request.setAttribute("sendError", "已提醒业主缴费");
		return mView;
	}
	
}
