package com.niuka.user.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.niuka.common.model.PersistentObject;

/** 
 * @author yhcui E-mail:ychui@yahoo.cn 
 * @version 创建时间：2017年9月13日 下午4:20:33 
 * 权限登录
 */

public class OauthLogin extends PersistentObject {

	private static final long serialVersionUID = 4526626792655972713L;
	
	// 快捷登录名称
	private String oauthName;
	// 身份ID
	private String oauthId;
	// 权限登录token
	private String oauthAccessToken;
	// 过期时间
	private Integer oauthExpires;
	// 用户ID
	private Integer userId;
	// 登录账号
	private String account;
	// 客户ID
	private Integer customerId;
	// 绑定时间
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createtime;

	public void setOauthName(String oauthName) {
		this.oauthName = oauthName;
	}

	public String getOauthName() {
		return this.oauthName;
	}

	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}

	public String getOauthId() {
		return this.oauthId;
	}

	public void setOauthAccessToken(String oauthAccessToken) {
		this.oauthAccessToken = oauthAccessToken;
	}

	public String getOauthAccessToken() {
		return this.oauthAccessToken;
	}

	public void setOauthExpires(Integer oauthExpires) {
		this.oauthExpires = oauthExpires;
	}

	public Integer getOauthExpires() {
		return this.oauthExpires;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return this.account;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getCreatetime() {
		return this.createtime;
	}
}
