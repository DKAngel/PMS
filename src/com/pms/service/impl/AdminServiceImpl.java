package com.pms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pms.dao.AdminMapper;
import com.pms.pojo.Admin;
import com.pms.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Resource(name = "adminMapper")
	private AdminMapper adminMapper;
	
	public Admin getByAdminId(Integer id){
		return adminMapper.selectByPrimaryKey(id);
	}

}
