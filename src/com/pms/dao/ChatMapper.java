package com.pms.dao;

import java.util.Date;
import java.util.List;

import com.pms.pojo.Chat;

public interface ChatMapper {
    int deleteByPrimaryKey(Integer chatId);

    int insert(Chat record);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Integer chatId);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);
    
    //
    int insertByOwner(Chat record);
    
    List<Chat> selectAllChat();
    
    List<Chat> selectAllChatByOwnerId(Integer ownerId);
    
    List<Chat> selectAllChatByTime(Date chatTime);
    
    int selectMaxId();
}