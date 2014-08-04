package com.xunta.android.bean;

import cn.bmob.v3.BmobObject;

/**
 * @Title: Users.java 
 * @Package com.xunta.android.bean
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangchao
 * @date 2014年8月3日 下午5:52:25 
 */
public class Users extends BmobObject{
	
	private String phoneNum;
	private String password;
	
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
