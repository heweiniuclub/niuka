package com.niuka.api.server.controller.param.input.bindphone;

/**
 * Created by admin on 2017/9/11.
 */
public class BindPhoneVO {

	private String phone;//绑定的手机号码
	private String openId;//第三方唯一标识
	private String headImg;
	private String nickName;
	private Integer sex;//0男 1女 2保密
	private String identifyingCode;
	private Integer bindType;//0微信公众号 1微信快捷登录 2QQ快捷登录 3微博快捷登录
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getIdentifyingCode() {
		return identifyingCode;
	}
	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
	public Integer getBindType() {
		return bindType;
	}
	public void setBindType(Integer bindType) {
		this.bindType = bindType;
	}
    
}
