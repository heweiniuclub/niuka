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

public interface CustomerUserApiService extends Service<CustomerUser, Integer> {

	/**
	 * 根据会员ID和客户ID查询是否存在这条记录
	 * @param userId
	 * @param customerId
	 * @return
	 */
	public CustomerUser findCustomerUserByUserIdAndCustomerId(String userId, Integer customerId);

	/**
	 * 根据open_id查询客户用户信息
	 * @param openId
	 * @return
	 */
	public CustomerUser queryUserByOpenId(String openId);

}
