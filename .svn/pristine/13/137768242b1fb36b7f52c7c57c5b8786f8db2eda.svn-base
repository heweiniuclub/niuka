package com.niuka.customer.rpc.api;

import com.niuka.common.service.mybatis.Service;
import com.niuka.customer.model.Customer;

/** 
 * @author yhcui E-mail:ychui@yahoo.cn 
 * @version 创建时间：2017年9月14日 下午7:23:00 
 * 类说明 
 */

public interface CustomerApiService extends Service<Customer, Integer> {

	/**
     * 检查客户是否存在
     * @param customerId
     * @return
     */
	public Customer checkCustomerExist(Integer customerId);

	/**
	 * 保存客户信息
	 * @param customer
	 */
	public void add(Customer customer);
	
}
