package com.pms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pms.pojo.Chat;
import com.pms.pojo.Owner;
import com.pms.service.ChatService;
import com.pms.utils.CleanStyle;
import com.pms.utils.GetNowTime;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/frontChatHandle")
public class FrontChatHandle {
	
	@Resource(name = "chatService")
	ChatService chatService;
	
	/**
	 * 聊天发言
	 * @param request
	 * @param session
	 * @return chat Controller
	 */
	@RequestMapping(value = "/chatHandle", method = RequestMethod.POST)
	public String chatHandle(HttpServletRequest request, HttpSession session){
		String str = request.getParameter("message");
		CleanStyle cleanStyle = new CleanStyle();
		String message = cleanStyle.cleanStyle(str);
		
		Owner owner = (Owner) session.getAttribute("owner");
		int ownerId = owner.getOwnersId();
		String ownerName = owner.getOwnersName();
		int roomId = owner.getRoomId();
		
		GetNowTime getNowTime = new GetNowTime();
		Date time = getNowTime.getNowTime();
		
		Chat chat = new Chat();
		chat.setChatContent(message);
		chat.setChatTime(time);
		chat.setOwnersId(ownerId);
		chat.setOwnersName(ownerName);
		chat.setRoomId(roomId);
		
		chatService.insertByOwner(chat);
		
		return "redirect:/frontIndex/chat";
	}
	
	/**
	 * 显示聊天详细内容
	 * @param chatId
	 * @return chatDetail.jsp
	 */
	@RequestMapping("/showChat/{chatId}")
	public ModelAndView showChat(@PathVariable String chatId){
		ModelAndView mView = new ModelAndView();
		
		Chat chat = chatService.getByChatId(Integer.valueOf(chatId));
		
		mView.addObject("chat", chat);
		mView.setViewName("/front/chatDetail");
        return mView;
	}
	
	/**
	 * 删除某条聊天记录
	 * @param chatId
	 * @return recordOfChat Controller
	 */
	@RequestMapping("/deleteChat/{chatId}")
	public String deleteChat(@PathVariable String chatId){
		
		int deletChat = chatService.deleteByChatId(Integer.valueOf(chatId));
		
		if(deletChat == 1){
			System.out.println("删除成功！");
			return "redirect:/frontIndex/recordOfChat";  
		}else{
			return null;
		}
	}
	
	/**
	 * 将聊天记录转为json格式
	 * @param response
	 * @param responseObject
	 */
	@RequestMapping("/ajaxChat")
	public void ajaxChat(HttpServletResponse response, Object responseObject) {
		List<Chat> chats = chatService.getAllChat();
		//将实体对象转换为JSONObject
		JSONArray jsonArray = JSONArray.fromObject(chats);
	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=utf-8");
	    PrintWriter out = null;
	    try {
	        out = response.getWriter();
	        out.append(jsonArray.toString()+"");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
