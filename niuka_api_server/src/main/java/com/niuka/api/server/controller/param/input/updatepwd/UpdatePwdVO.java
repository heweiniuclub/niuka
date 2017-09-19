package com.niuka.api.server.controller.param.input.updatepwd;

/**
 * Created by admin on 2017/9/11.
 */
public class UpdatePwdVO {

	private String oldPassword;//旧密码
	private String password;// 新密码
	private String rePassword;// 确认密码
	private Integer userId;//用户ID
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
    
}
