package com.niuka.customer.dao.api;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.customer.model.Customer;

import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/9/7.
 */
public interface CustomerMapper extends Dao<Customer, Integer> {

	/**
	 * 根据客户ID查询客户是否存在
	 * @param customerId
	 * @return
	 */
	public Customer findCustomerExistByCustomerId(@Param("customerId") Integer customerId);


}
