package com.xunta.android.bean;

import cn.bmob.v3.BmobObject;

/**
 * @Title: XuntaData.java 
 * @Package com.xunta.android.bean
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangchao
 * @date 2014年8月4日 下午10:37:02 
 */
@SuppressWarnings("serial")
public class XuntaData extends BmobObject{

	private String userName;
	private String userId;
	private String photoUrl;
	private String content;
	private String imgUrl;
	private String loction;
	private int praiseNum;
	private String tag;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getLoction() {
		return loction;
	}
	public void setLoction(String loction) {
		this.loction = loction;
	}
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
