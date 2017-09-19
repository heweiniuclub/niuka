package com.niuka.api.server.controller.param.input.paypassword;

/**
 * Created by admin on 2017/9/11.
 */
public class PayPasswordVO {

    private String newPwd;// 新密码
    private Integer personalId;//登录用户id
    private String phone;// 手机号
    private String identifyingCode;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public Integer getPersonalId() {
        return personalId;
    }

    public void setPersonalId(Integer personalId) {
        this.personalId = personalId;
    }

	public String getIdentifyingCode() {
		return identifyingCode;
	}

	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}
 
}
