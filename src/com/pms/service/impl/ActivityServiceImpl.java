package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.ActivityMapper;
import com.pms.pojo.Activity;
import com.pms.service.ActivityService;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
	
	@Resource(name = "activityMapper")
	private ActivityMapper activityMapper;
	
	public int insertByOwner(Activity record){
		return activityMapper.insertByOwner(record);
	}
	
	public List<Activity> getAllActivityBy1(){
		return activityMapper.selectAllActivityBy1();
	}
	
	public Activity getByActivityId(Integer id){
		return activityMapper.selectByPrimaryKey(id);
	}
	
	public List<Activity> getAllActivityByOwnerId(Integer ownerId){
		return activityMapper.selectAllActivityByOwnerId(ownerId);
	}
	
	public int deleteByPrimaryKey(Integer activityId){
		return activityMapper.deleteByPrimaryKey(activityId);
	}
}

