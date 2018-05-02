package com.pms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.OwnerMapper;
import com.pms.pojo.Owner;
import com.pms.service.OwnerService;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{
	@Resource(name = "ownerMapper")
	private OwnerMapper ownerMapper;
	
	public int insertByRegister(Owner owner){
		return ownerMapper.insertByRegister(owner);
	}
	
	public Owner selectByEmail(String ownerEmail){
		return ownerMapper.selectByEmail(ownerEmail);
	}
	
	public int updatePasswordByEmail(String password, String email){
		return ownerMapper.updatePasswordByEmail(password, email);
	}
	
	public int updateInfoByEmail(String password, String sex, String phone, String email){
		return ownerMapper.updateInfoByEmail(password, sex, phone, email);
	}
	
	public int updateAccountByEmail(String newEmail, String password, String oldEmail){
		return ownerMapper.updateAccountByEmail(newEmail, password, oldEmail);
	}
	
	public Owner getByOwnerId(Integer ownerId){
		return ownerMapper.selectByPrimaryKey(ownerId);
	}
	
	public List<Owner> getAllOwner(){
		return ownerMapper.selectAllOwner();
	}
	
	public int deleteByPrimaryKey(Integer ownersId){
		return ownerMapper.deleteByPrimaryKey(ownersId);
	}
}
