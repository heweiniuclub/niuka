package com.niuka.api.server.controller.param.input.register;

import com.niuka.api.server.controller.param.input.CommonVO;
import com.niuka.api.server.controller.param.input.login.LoginVO;

/** 
 * @author yhcui E-mail:ychui@yahoo.cn 
 * @version 创建时间：2017年9月15日 下午4:19:37 
 * 类说明 
 */

public class RegisterVO extends CommonVO {
	
	private String username;//用户名
	
	private String identifyingCode;//验证码
	
	private String password;//密码

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdentifyingCode() {
		return identifyingCode;
	}

	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
