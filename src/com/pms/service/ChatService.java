package com.pms.service;

import java.util.Date;
import java.util.List;

import com.pms.pojo.Chat;

public interface ChatService {
	public int insertByOwner(Chat record);
	public List<Chat> getAllChat();
	public List<Chat> getAllChatByOwnerId(Integer ownerId);
	public int deleteByChatId(Integer chatId);
	public Chat getByChatId(Integer id );
	public List<Chat> getAllChatByTime(Date chatTime);
	public int getMaxId();
	public int deleteByOwnerId(Integer ownerId);
}
