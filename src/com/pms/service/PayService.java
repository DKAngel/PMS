package com.pms.service;

import com.pms.pojo.Pay;

public interface PayService {
	public int insertByOwner(Pay record);
	public Pay getMaxPayByOwner(Integer ownerId);
}
