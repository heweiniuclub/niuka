package com.niuka.api.server.controller.param.input.msg;

/**
 * Created by admin on 2017/9/11.
 */
public class SendMsgVO {
	
	private String phone;// 手机号码
	private Integer type;// 发送类型： 1为注册短信验证 ，2快捷登录验证码，3忘记密码验证码，4修改绑定手机验证码，5修改支付密码

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
