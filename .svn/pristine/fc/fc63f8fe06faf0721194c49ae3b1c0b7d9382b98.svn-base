package com.niuka.customer.rpc.api;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.niuka.common.exception.DaoException;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.service.mybatis.Service;
import com.niuka.customer.model.CustomerUser;

/** 
 * @author jiangtao
 * @version 创建时间：2017年9月14日 下午7:23:00 
 * 类说明 
 */

public interface CustomerUserJtaApiService extends Service<CustomerUser, Integer> {

	/**
	 * 客户会员关系记录添加
	 * @param customerUser
	 * @return
	 */
	@Transactional
	public Integer addCustomerUser(CustomerUser customerUser) throws DaoException;

	/**
	 * 根据客户ID和账号修改登录密码
	 * @param username
	 * @param customerId
	 * @param password
	 */
	@Transactional
	public void updateUserPwdByAccount(String username, Integer customerId, String password) throws DaoException;

	/**
	 * 根据账号和客户ID更新微信公众号唯一标识
	 * @param userName
	 * @param customerId
	 */
	@Transactional
	public void updateOpenIdByAccountAndCustomerId(String userName, Integer customerId, String openId) throws DaoException;

	/**
	 * 更新用户密码
	 * @param account
	 * @param customerId
	 * @param encrypt
	 */
	@Transactional
	public void updateUserPwd(String account, Integer customerId, String encrypt) throws DaoException;

	/**
	 * 更新用户密码
	 * @param params
	 * @return
	 */
	@Transactional
	public Map<String, Object> updatePassword(ExtendMap<String, Object> params) throws DaoException;

}
