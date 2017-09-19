package com.niuka.customer.model;

import java.util.Date;

import com.niuka.common.model.PersistentObject;

/**
 * @author yhcui E-mail:ychui@yahoo.cn
 * @version 创建时间：2017年9月13日 下午9:02:15 类说明
 */

public class CustomerUser extends PersistentObject {

	private static final long serialVersionUID = 7503956665813850555L;

	// 门店编号
	private String storeNo;
	// 登录名
	private String account;
	// 客户ID
	private Integer customerId;
	// 用户ID
	private Integer userId;
	// 门店ID
	private Integer customerStoreId;
	// 创建时间
	private Date createtime;
	// 登录密码
	private String password;
	// 微信公众号open_id
	private String openId;

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreNo() {
		return this.storeNo;
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

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setCustomerStoreId(Integer customerStoreId) {
		this.customerStoreId = customerStoreId;
	}

	public Integer getCustomerStoreId() {
		return this.customerStoreId;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
