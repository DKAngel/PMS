package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.PayMapper;
import com.pms.pojo.Pay;
import com.pms.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService {
	@Resource(name = "payMapper")
	private PayMapper payMapper;
	
	public int insertByOwner(Pay pay){
		return payMapper.insertByOwner(pay);
	}
	
	public Pay getMaxPayByOwner(Integer ownerId){
		return payMapper.selectMaxPayByOwner(ownerId);
	}
}
