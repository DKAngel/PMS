package com.pms.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowTime {
	public Date getNowTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String stime = df.format(new Date());// new Date()为获取当前系统时间
		Date nowTime = null;
		try {
			nowTime = df.parse(stime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nowTime;
	}
}
