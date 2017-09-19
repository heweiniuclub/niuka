package com.niuka.user.model;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.niuka.common.model.PersistentObject;

public class PersonalMember extends PersistentObject {

	private static final long serialVersionUID = 7902814112969375973L;
	
	// 用户ID
	private Integer userId;
	// 客户ID
	private Integer customerId;
	// (头像)
	private String headImg;
	// (昵称)
	private String nickName;
	// 性别（0男、1女、2保密）
	private Integer sex;
	// (真实姓名)
	private String trueName;
	// (联系电话)
	private String phone;
	// (冻结金额)
	private BigDecimal canuseMoney;
	// (会员余额)
	private BigDecimal balance;
	// 会员历史充值金额
	private BigDecimal totalAmount;
	// (是否有效0有效 1无效)
	private Integer isvalid;
	// (会员积分)
	private Integer integral;
	// (历史总积分)
	private Integer totalIntegral;
	// 总的赠送金额
	private BigDecimal giveBalance;
	//支付密码
	private String payPassword;
	
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setCanuseMoney(BigDecimal canuseMoney) {
		this.canuseMoney = canuseMoney;
	}

	public BigDecimal getCanuseMoney() {
		return this.canuseMoney;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getTotalAmount() {
		return this.totalAmount;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getIntegral() {
		return this.integral;
	}

	public void setTotalIntegral(Integer totalIntegral) {
		this.totalIntegral = totalIntegral;
	}

	public Integer getTotalIntegral() {
		return this.totalIntegral;
	}

	public void setGiveBalance(BigDecimal giveBalance) {
		this.giveBalance = giveBalance;
	}

	public BigDecimal getGiveBalance() {
		return this.giveBalance;
	}
	
	public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(Integer isvalid) {
		this.isvalid = isvalid;
	}

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

}
