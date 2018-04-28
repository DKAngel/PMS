package com.pms.service;

import java.util.List;

import com.pms.pojo.Upkeep;

public interface UpkeepService {
	public int insertByOwner(Upkeep record);
	public List<Upkeep> getAllUpkeep();
	public Upkeep getByUpkeepId(Integer id);
	public int deleteByUpkeepId(Integer id);
	public List<Upkeep> getAllUpkeepByOwner(Integer ownerId);
	public int updateByAdmin(Upkeep record);
}
