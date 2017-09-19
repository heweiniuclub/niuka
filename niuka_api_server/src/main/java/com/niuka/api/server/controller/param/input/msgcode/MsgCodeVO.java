package com.niuka.api.server.controller.param.input.msgcode;

import com.niuka.api.server.controller.param.input.CommonVO;
import com.niuka.api.server.controller.param.input.login.LoginVO;

/** 
 * @author yhcui E-mail:ychui@yahoo.cn 
 * @version 创建时间：2017年9月15日 下午4:19:37 
 * 类说明 
 */

public class MsgCodeVO extends CommonVO {
	
	private String phone;//用户名
	private String identifyingCode;//验证码
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentifyingCode() {
		return identifyingCode;
	}

	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}

}
