package com.pms.service;

import java.util.List;

import com.pms.pojo.Owner;

public interface OwnerService {
	public int insertByRegister(Owner owner);
	public Owner selectByEmail(String ownersEmail);
	public int updatePasswordByEmail(String password, String email);
	public int updateInfoByEmail(String password, String sex, String phone, String email);
	public int updateAccountByEmail(String newEmail, String password, String oldEmail);
	public Owner getByOwnerId(Integer id); 
	public List<Owner> getAllOwner();
	public int deleteByPrimaryKey(Integer ownersId);
	public int updateInfoByOwnerId(Owner owner);
}
