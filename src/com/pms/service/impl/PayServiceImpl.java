package com.pms.service.impl;

import java.util.List;

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
	
	public List<Pay> getAllByOwnerId(Integer ownerId){
		return payMapper.selectAllByOwnerId(ownerId);
	}
	
	public List<Pay> getAllPay(){
		return payMapper.selectAllPay();
	}
	
	public List<Pay> getAllPayByRoom(){
		return payMapper.selectAllPayByRoom();
	}
	
	public Pay getPayByPayId(Integer ownersId){
		return payMapper.selectPayByPayId(ownersId);
	}
}
