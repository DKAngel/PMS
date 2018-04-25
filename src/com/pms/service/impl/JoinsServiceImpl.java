package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.JoinsMapper;
import com.pms.pojo.Joins;
import com.pms.service.JoinsService;

@Service("joinsService")
public class JoinsServiceImpl implements JoinsService{
	@Resource(name = "joinsMapper")
	private JoinsMapper joinsMapper;
	
	public int insertByOwner(Joins record){
		return joinsMapper.insertByOwner(record);
	}
    
    public List<Joins> getByActivityId(Integer activityId){
    	return joinsMapper.selectByActivityId(activityId);
    }
    
    public Joins getByActivityIdAndOwnerId(Integer activityId, Integer ownersId){
    	return joinsMapper.selectByActivityIdAndOwnerId(activityId, ownersId);
    }
}
