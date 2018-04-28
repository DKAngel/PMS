package com.pms.service;

import java.util.List;

import com.pms.pojo.Complain;

public interface ComplainService {
	public int insertByOwner(Complain record);
	public List<Complain> getAllComplain();
	public Complain getByComplainId(Integer id);
	public int deleteByComplainId(Integer id);
	public List<Complain> getAllComplainByOwner(Integer ownerId);
	public int updateByAdmin(Complain record);
}
