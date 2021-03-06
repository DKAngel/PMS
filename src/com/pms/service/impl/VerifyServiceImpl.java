package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.VerifyMapper;
import com.pms.pojo.Verify;
import com.pms.service.VerifyService;

@Service("verifyService")
public class VerifyServiceImpl implements VerifyService{
	@Resource(name = "verifyMapper")
	private VerifyMapper verifyMapper;
	
	public Verify getByActivityId(Integer activityId){
		return verifyMapper.selectByActivityId(activityId);
	}
	
	public int insertByAdmin(Verify record){
		return verifyMapper.insertByAdmin(record);
	}
	
	public int deleteByActivityId(Integer activityId){
		return verifyMapper.deleteByActivityId(activityId);
	}
	
	public int deleteByActivityOwner(Integer ownerId){
		return verifyMapper.deleteByActivityOwner(ownerId);
	}
}
