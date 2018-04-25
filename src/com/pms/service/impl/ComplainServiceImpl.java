package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.ComplainMapper;
import com.pms.pojo.Complain;
import com.pms.service.ComplainService;

@Service("complainService")
public class ComplainServiceImpl implements ComplainService{
	
	@Resource(name = "complainMapper")
	private ComplainMapper complainMapper;
	
	public int insertByOwner(Complain record){
		return complainMapper.insertByOwner(record);
	}
	
	public List<Complain> getAllComplain(){
		return complainMapper.selectAllComplain();
	}
	
	public Complain getByComplainId(Integer id){
		return complainMapper.selectByPrimaryKey(id);
	}
	
	public int deleteByComplainId(Integer id){
		return complainMapper.deleteByPrimaryKey(id);
	}
	
	public List<Complain> getAllComplainByOwner(Integer ownerId){
		return complainMapper.selectAllComplainByOwner(ownerId);
	}
}
