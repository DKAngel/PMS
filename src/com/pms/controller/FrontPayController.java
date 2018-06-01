package com.pms.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Owner;
import com.pms.pojo.Pay;
import com.pms.pojo.Room;
import com.pms.service.PayService;
import com.pms.service.RoomService;
import com.pms.utils.GetNowTime;

@Controller
@RequestMapping(value = "/frontPay")
public class FrontPayController {
	
	@Resource(name = "payService")
	PayService payService;
	
	@Resource(name = "roomService")
	RoomService roomService;
	
	/**
	 * 确认支付
	 * @param session
	 * @param request
	 * @return true:index Controller false:pay.jsp
	 */
	@RequestMapping("/surePay")
	public ModelAndView surePay( HttpSession session, HttpServletRequest request){
		
		ModelAndView mView = new ModelAndView();

		Owner owner = (Owner) session.getAttribute("owner");
		if(owner == null){
			mView.setViewName("/front/login");
			return mView;
		}
		
		int ownerId = owner.getOwnersId();
		int roomId = owner.getRoomId();
		
		Room room = roomService.getByPrimaryKey(roomId);
		int roomSize = room.getRoomSize();
		double money = roomSize * 1.5;
		
		GetNowTime getNowTime = new GetNowTime();
		Date nowTime = getNowTime.getNowTime();
		
		Pay pay = new Pay();
		pay.setPayTime(nowTime);
		pay.setPayPrice(money);
		pay.setOwnersId(ownerId);
		
		Pay oldPay = payService.getMaxPayByOwner(ownerId);
		if(oldPay != null){
			long loldTime = oldPay.getPayTime().getTime();
			long lnowTime = nowTime.getTime();  
			int days = (int) ((lnowTime - loldTime)/(1000 * 60 * 60 * 24));
			if(days < 30){
				System.out.println("这个月已交过费");
				request.setAttribute("timeError", "这个月已交过费");
				mView.addObject("roomId",roomId);
				mView.addObject("roomSize", roomSize);
				mView.addObject("cost", money);
				mView.setViewName("/front/pay");
				return mView;
			}
		}
		
		payService.insertByOwner(pay);
		
		roomService.updateByPay(roomId);
		
		System.out.println("支付成功");
		mView.setViewName("redirect:/frontLogin/index");
		return mView;
	}
	
}
