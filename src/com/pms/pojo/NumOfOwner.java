package com.pms.pojo;

public class NumOfOwner {
	private static NumOfOwner instance = new NumOfOwner();
	public static int numOfOwner;
	private NumOfOwner(){}
	public static NumOfOwner getInstance(){
		return instance;
	}
}
