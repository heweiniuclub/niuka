package com.niuka.customer.service.api;

import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.customer.dao.api.CustomerMapper;
import com.niuka.customer.model.Customer;
import com.niuka.customer.rpc.api.CustomerApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerapiservice")
public class CustomerApiServiceImpl extends ServiceImpl<CustomerMapper, Customer, Integer> implements CustomerApiService {

	@Autowired
	public void setDao(CustomerMapper dao) {
		this.dao = dao;
	}

	@Override
	public Customer checkCustomerExist(Integer customerId) {
		return dao.findCustomerExistByCustomerId(customerId);
	}

	@Override
	public void add(Customer customer) {
		dao.insert(customer);
	}

}
