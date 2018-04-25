package com.pms.service;

import java.util.List;

import com.pms.pojo.Activity;

public interface ActivityService {
	public int insertByOwner(Activity record);
	public List<Activity> getAllActivityBy1();
	public Activity getByActivityId(Integer id);
	public List<Activity> getAllActivityByOwnerId(Integer ownerId);
	public int deleteByPrimaryKey(Integer activityId);
}
