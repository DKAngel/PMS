package com.pms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Activity;
import com.pms.pojo.Admin;
import com.pms.pojo.Joins;
import com.pms.pojo.Owner;
import com.pms.pojo.Verify;
import com.pms.service.ActivityService;
import com.pms.service.AdminService;
import com.pms.service.JoinsService;
import com.pms.service.VerifyService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;

@Controller
@RequestMapping(value = "/frontActivity")
public class FrontActivityController {
	
	@Resource(name = "activityService")
	ActivityService activityService;
	
	@Resource(name = "joinsService")
	JoinsService joinsService;
	
	@Resource(name = "verifyService")
	VerifyService verifyService;
	
	@Resource(name = "adminService")
	AdminService adminService;
	
	/**
	 * 发布活动
	 * @param request
	 * @param session
	 * @return activity.jsp
	 */
	@RequestMapping("/publishActivity")
	public ModelAndView publishActivity(HttpServletRequest request, HttpSession session){
		
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/activity");
		
		CleanStyle cleanStyle = new CleanStyle();
		
		String inputtheme = request.getParameter("theme");
		String theme = cleanStyle.cleanStyle(inputtheme);
		
		String shtime = request.getParameter("htime")+":00";
		
		String inputcontent = request.getParameter("textarea");
		String content = cleanStyle.cleanStyle(inputcontent);
		
		GetNowTime nowTime = new GetNowTime();
		Date ptime = nowTime.getNowTime();
		
		//String转为Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date htime = null;
		try {
			htime = sdf.parse(shtime);
		} catch (ParseException e) {
			System.out.println("异常");
			request.setAttribute("timeError", "时间格式不对");
			return mView;
		}
		
		//计算时间差
		long lnowtime = ptime.getTime();  
		long lholdtime = htime.getTime();
		int minutes = (int) ((lholdtime - lnowtime)/(1000 * 60));  
		if(minutes < 600){
			request.setAttribute("timeError", "活动举行时间必须是10个小时以后");
			return mView;
		}
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();
		String ownerName = owner.getOwnersName();
		
		Activity activity = new Activity();
		activity.setActivityTheme(theme);
		activity.setActivityContent(content);
		activity.setActivityPtime(ptime);
		activity.setActivityHtime(htime);
		activity.setActivityState(0);
		activity.setOwnersId(ownerId);
		activity.setOwnersName(ownerName);
		
		activityService.insertByOwner(activity);
		
		return mView;
	}
	
	/**
	 * 发起活动，活动详情，包括活动内容和活动参加者信息
	 * @param activityId
	 * @return activityDetail.jsp
	 */
	@RequestMapping("/activityDetail/{activityId}")
	public ModelAndView activityDetail(@PathVariable String activityId) {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/activityDetail");
		
		Activity activity = activityService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("activity", activity);
		
		List<Joins> joinList = joinsService.getByActivityId(Integer.valueOf(activityId));
		mView.addObject("joinList", joinList);
		
        return mView;
	}
	
	/**
	 * 参加活动，判断是否已经参加过活动
	 * @param activityId
	 * @param response
	 * @param session
	 * @return activity Controller
	 * @throws IOException
	 */
	@RequestMapping("/activityJoin/{activityId}")
	public String activityJoin(@PathVariable String activityId, HttpSession session) {
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();
		
		Joins joins = joinsService.getByActivityIdAndOwnerId(Integer.valueOf(activityId), ownerId);
		if(joins != null){
			System.out.println("您已经参加过该活动了");
			return "redirect:/frontIndex/activity";
		}
		
		String ownerName = owner.getOwnersName();
		String ownerPhone = owner.getOwnersPhone();
		int roomId = owner.getRoomId();
		
		Joins join = new Joins();
		join.setOwnersName(ownerName);
		join.setOwnersPhone(ownerPhone);
		join.setOwnersId(ownerId);
		join.setRoomId(roomId);
		join.setActivityId(Integer.valueOf(activityId));
		
		joinsService.insertByOwner(join);
		
		return "redirect:/frontIndex/activity";
	}
	
	/**
	 * 删除活动
	 * @param activityId
	 * @return recordOfActivity.jsp
	 */
	@RequestMapping("/activityDelete/{activityId}")
	public String activityDelete(@PathVariable String activityId) {
		
		joinsService.deleteByActivityId(Integer.valueOf(activityId));
		
		verifyService.deleteByActivityId(Integer.valueOf(activityId));
		
		int deleteActivity = activityService.deleteByPrimaryKey(Integer.valueOf(activityId));
		
		if(deleteActivity == 1){
			System.out.println("删除成功！");
			return "redirect:/frontIndex/recordOfActivity";  
		}else{
			return null;
		}
	}
	
	/**
	 * 个人中心，活动记录详细界面(包括审核内容)
	 * @param activityId
	 * @return activityVerify.jsp
	 */
	@RequestMapping("/activityVerify/{activityId}")
	public ModelAndView activityVerify(@PathVariable String activityId) {
		ModelAndView mView = new ModelAndView();
		mView.setViewName("/front/activityVerify");
		
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
		
        return mView;
	}
}
