package com.pms.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.ChatMapper;
import com.pms.pojo.Chat;
import com.pms.service.ChatService;

@Service("chatService")
public class ChatServiceImpl implements ChatService{
	
	@Resource(name = "chatMapper")
	private ChatMapper chatMapper;
	
	public int insertByOwner(Chat record){
		return chatMapper.insertByOwner(record);
	}
	
	public List<Chat> getAllChat(){
		return chatMapper.selectAllChat();
	}
	
	public List<Chat> getAllChatByOwnerId(Integer ownerId){
		return chatMapper.selectAllChatByOwnerId(ownerId);
	}
	
	public int deleteByChatId(Integer chatId){
		return chatMapper.deleteByPrimaryKey(chatId);
	}
	
	public Chat getByChatId(Integer id){
		return chatMapper.selectByPrimaryKey(id);
	}
	
	public List<Chat> getAllChatByTime(Date chatTime){
		return chatMapper.selectAllChatByTime(chatTime);
	}
	
	public int getMaxId(){
		return chatMapper.selectMaxId();
	}
	
	public int deleteByOwnerId(Integer ownerId){
		return chatMapper.deleteByOwnerId(ownerId);
	}
	
	public List<Chat> getChat100(){
		return chatMapper.selectChat100();
	}
}
