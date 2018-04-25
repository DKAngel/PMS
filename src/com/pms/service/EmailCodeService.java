package com.pms.service;

import com.pms.pojo.EmailCode;

public interface EmailCodeService {
	public int insertByNoId(EmailCode emailCode);
	public EmailCode getByEmail(String email);
	public int updateByEmail(String code, String email);
}
