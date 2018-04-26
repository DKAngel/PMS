package com.pms.service;

import java.util.List;

import com.pms.pojo.Pay;

public interface PayService {
	public int insertByOwner(Pay record);
	public Pay getMaxPayByOwner(Integer ownerId);
	public List<Pay> getAllByOwnerId(Integer ownerId);
}
