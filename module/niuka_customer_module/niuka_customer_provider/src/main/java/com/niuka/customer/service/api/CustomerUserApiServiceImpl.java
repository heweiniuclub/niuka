package com.niuka.customer.service.api;

import java.util.HashMap;
import java.util.Map;

import com.niuka.common.exception.DaoException;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.provider.PasswordProvider;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.customer.dao.api.CustomerMapper;
import com.niuka.customer.dao.api.CustomerUserMapper;
import com.niuka.customer.model.Customer;
import com.niuka.customer.model.CustomerUser;
import com.niuka.customer.rpc.api.CustomerApiService;
import com.niuka.customer.rpc.api.CustomerUserApiService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service("customerUserapiservice")
public class CustomerUserApiServiceImpl extends ServiceImpl<CustomerUserMapper, CustomerUser, Integer> implements CustomerUserApiService {

	@Autowired
	public void setDao(CustomerUserMapper dao) {
		this.dao = dao;
	}

	@Override
	public CustomerUser findCustomerUserByUserIdAndCustomerId(String userId, Integer customerId) {
		return dao.findCustomerUserByUserIdAndCustomerId(userId, customerId);
	}

	@Override
	public CustomerUser queryUserByOpenId(String openId) {
		return dao.queryUserByOpenId(openId);
	}

}
