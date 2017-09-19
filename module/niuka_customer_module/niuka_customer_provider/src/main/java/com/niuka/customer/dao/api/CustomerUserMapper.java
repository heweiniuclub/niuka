package com.niuka.customer.dao.api;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.customer.model.Customer;
import com.niuka.customer.model.CustomerUser;

import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/9/7.
 */
public interface CustomerUserMapper extends Dao<CustomerUser, Integer> {

	/**
	 * 添加客户用户关系记录
	 * @param customerUser
	 * @return
	 */
	Integer addCustomerUser(@Param("customerUser") CustomerUser customerUser);

	/**
	 * 根据客户ID和账号修改登录密码
	 * @param username
	 * @param customerId
	 * @param password
	 * @return
	 */
	int updateUserPwdByAccount(@Param("username")String username, @Param("customerId") Integer customerId, @Param("password") String password);

	/**
	 * 根据会员ID和客户ID查询是否存在这条记录
	 * @param userId
	 * @param customerId
	 * @return
	 */
	CustomerUser findCustomerUserByUserIdAndCustomerId(@Param("userId") String userId, @Param("customerId") Integer customerId);

	/**
	 * 根据open_id查询客户用户信息
	 * @param openId
	 * @return
	 */
	CustomerUser queryUserByOpenId(@Param("openId") String openId);

	/**
	 * 根据账号和客户ID更新微信公众号唯一标识
	 * @param userName
	 * @param customerId
	 * @param openId
	 * @return
	 */
	int updateOpenIdByAccountAndCustomerId(@Param("userName") String userName, @Param("customerId") Integer customerId, @Param("openId") String openId);

	int updateUserPwd(@Param("username")String username, @Param("customerId") Integer customerId, @Param("password") String password);


}
