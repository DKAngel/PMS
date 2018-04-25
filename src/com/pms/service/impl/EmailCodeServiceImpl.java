package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.EmailCodeMapper;
import com.pms.pojo.EmailCode;
import com.pms.service.EmailCodeService;

@Service("emailCodeService")
public class EmailCodeServiceImpl implements EmailCodeService{
	
	@Resource(name = "emailCodeMapper")
	private EmailCodeMapper emailCodeMapper;

	public int insertByNoId(EmailCode emailCode){
		return emailCodeMapper.insertByNoId(emailCode);
	}
	
	public EmailCode getByEmail(String email){
		return emailCodeMapper.selectByEmail(email);
	}
	
	public int updateByEmail(String code, String email){
		return emailCodeMapper.updateByEmail(code, email);
	}
}


