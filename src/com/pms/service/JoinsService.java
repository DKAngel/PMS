package com.pms.service;

import java.util.List;

import com.pms.pojo.Joins;

public interface JoinsService {
	public int insertByOwner(Joins record);
    
    public List<Joins> getByActivityId(Integer id);
    
    public Joins getByActivityIdAndOwnerId(Integer activityId, Integer ownersId);
}
