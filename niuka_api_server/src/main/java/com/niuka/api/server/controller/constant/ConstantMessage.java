/*
 * 文 件 名:  ApiConstant.java
 * 版    权:  Zskj Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:   hewei
 * 修改时间:  2016年6月6日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.niuka.api.server.controller.constant;

import java.util.ResourceBundle;

/**
 * 接口结果码常量
 * 
 * @author HEWEI
 * @version [版本号, 2016年6月6日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class ConstantMessage {

	private final static ResourceBundle RESOURC_EBUNDLE;

	static {
		RESOURC_EBUNDLE = ResourceBundle.getBundle("message");
	}

	/**
	 * 用户开始
	 */
	// 用户已禁用
	public static final String USER_LOGIN_ERROR_IS_DISABLE = RESOURC_EBUNDLE.getString(
			"user_login_error_is_disable");

	// 用户不存在
	public static final String USER_LOGIN_ERROR_IS_NOT_EXIT = RESOURC_EBUNDLE.getString(
			"user_login_error_is_not_exit");

	// 用户不存在或者密码错误
	public static final String USER_LOGIN_ERROR_IS_NOT_EXIT_PWD_ERROR = RESOURC_EBUNDLE.getString(
			"user_login_error_is_not_exit_pwd_error");

	// 验证码失效
	public static final String USER_REGISTER_IDENTIFYINGCODE_FAILURE = RESOURC_EBUNDLE.getString(
			"user_register_identifyingcode_failure");

	// 验证码错误
	public static final String USER_REGISTER_IDENTIFYINGCODE_ERROR = RESOURC_EBUNDLE.getString(
			"user_register_identifyingcode_error");

	// 手机号码错误
	public static final String USER_SENDMSG_PHONE_ERROR = RESOURC_EBUNDLE.getString(
			"user_sendmsg_phone_error");

	// 手机号码已存在
	public static final String USER_SENDMSG_PHONE_IS_EXIT = RESOURC_EBUNDLE.getString(
			"user_sendmsg_phone_is_exit");

	// 手机号码不存在
	public static final String USER_SENDMSG_PHONE_NOT_EXIT = RESOURC_EBUNDLE.getString(
			"user_sendmsg_phone_not_exit");

	/**
	 * 注册短信内容
	 */
	public static final String USER_SENDMSG_REGITER_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_regiter_msg");

	/**
	 * 忘记密码
	 */
	public static final String USER_SENDMSG_FORGETPWD_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_forgetpwd_msg");
	/**
	 * 修改密码
	 */
	public static final String USER_UPDATEPHONE_OLDPWD_MSG = RESOURC_EBUNDLE.getString(
			"user_updatephone_oldpwd_msg");
	/**
	 * 绑定旧手机号输入错误
	 */
	public static final String USER_UPDATEPHONE_OLDPHONE_MSG = RESOURC_EBUNDLE.getString(
			"user_updatephone_oldphone_msg");

	/**
	 * 申请入会短信
	 */
	public static final String USER_SENDMSG_APPLYCOMMERCE_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_applyCommerce_msg");

	/**
	 * 店铺入驻短信
	 */
	public static final String USER_SENDMSG_SHOPAPPLY_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_shopApply_msg");

	/**
	 * 修改手机号码
	 */
	public static final String USER_SENDMSG_CHANGEPHONE_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_changephone_msg");

	/**
	 * 修改支付密码
	 */
	public static final String USER_SENDMSG_CHANGEPAYPASSWORD_MSG = RESOURC_EBUNDLE.getString(
			"user_sendmsg_changepaypassword_msg");

	/**
	 * 用户结束
	 */

	/***** 支付开始 ****************/
	/**
	 * 订单已支付
	 */
	public static final String ORDER_ERROR_IS_PAY = RESOURC_EBUNDLE.getString("order_error_is_pay");
	public static final String ORDER_ERROR_SERVER_ERROR = RESOURC_EBUNDLE.getString("order_error_server_error");
	public static final String ORDER_ERROR_NOT_EXIT  = RESOURC_EBUNDLE.getString("order_error_not_exit");
	public static final String ORDER_ERROR_BALANCE_NOT_SUFFICIENT_FUNDS  = RESOURC_EBUNDLE.getString("order_error_balance_not_sufficient_funds");
	public static final String ORDER_ERROR_INTRAGER_NOT_SUFFICIENT_FUNDS  = RESOURC_EBUNDLE.getString("order_error_intrager_not_sufficient_funds");

	/***** 支付借宿 ****************/

	public static void main(String[] args) {
		System.out.println(USER_SENDMSG_CHANGEPHONE_MSG);
	}
}
