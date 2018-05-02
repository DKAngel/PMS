package com.pms.service;

import com.pms.pojo.Verify;

public interface VerifyService {
	public Verify getByActivityId(Integer activityId);
	public int insertByAdmin(Verify record);
	public int deleteByActivityId(Integer activityId);
    public int deleteByActivityOwner(Integer ownerId);
}
