package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.UpkeepMapper;
import com.pms.pojo.Upkeep;
import com.pms.service.UpkeepService;

@Service("upkeepService")
public class UpkeepServiceImpl implements UpkeepService{
	@Resource(name = "upkeepMapper")
	private UpkeepMapper upkeepMapper;
	
	public int insertByOwner(Upkeep record){
		return upkeepMapper.insertByOwner(record);
	}
	
	public List<Upkeep> getAllUpkeep(){
		return upkeepMapper.selectAllUpkeep();
	}
	
	public Upkeep getByUpkeepId(Integer id){
		return upkeepMapper.selectByPrimaryKey(id);
	}
	
	public int deleteByUpkeepId(Integer id){
		return upkeepMapper.deleteByPrimaryKey(id);
	}
	
	public List<Upkeep> getAllUpkeepByOwner(Integer ownerId){
		return upkeepMapper.selectAllUpkeepByOwner(ownerId);
	}
}
