package com.niuka.api.server.controller.param.input.bindphone;

/**
 * Created by admin on 2017/9/11.
 */
public class CheckBindPhoneVO {

	private String openId;//第三方唯一标识
	private Integer bindType;//0微信公众号 1微信快捷登录 2QQ快捷登录 3微博快捷登录
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Integer getBindType() {
		return bindType;
	}
	public void setBindType(Integer bindType) {
		this.bindType = bindType;
	}
    
}
