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
import com.niuka.customer.rpc.api.CustomerUserJtaApiService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

@Service("customerUserJtaApiService")
public class CustomerUserJtaApiServiceImpl extends ServiceImpl<CustomerUserMapper, CustomerUser, Integer> implements CustomerUserJtaApiService {

	@Resource
	private CustomerUserApiService customerUserapiservice;
	@Autowired
	public void setDao(CustomerUserMapper dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public Integer addCustomerUser(CustomerUser customerUser) throws DaoException {
		return dao.insert(customerUser);
//		return dao.addCustomerUser(customerUser);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public void updateUserPwdByAccount(String username, Integer customerId, String password) throws DaoException {
		 dao.updateUserPwdByAccount(username, customerId, password);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public void updateOpenIdByAccountAndCustomerId(String userName, Integer customerId, String openId) throws DaoException {
		dao.updateOpenIdByAccountAndCustomerId(userName, customerId, openId);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public void updateUserPwd(String username, Integer customerId, String password) throws DaoException {
		 dao.updateUserPwd(username, customerId, password);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public Map<String, Object> updatePassword(ExtendMap<String, Object> params) throws DaoException {
		Map<String, Object> result = new HashMap<String, Object>();
        try {
            // 检查参数
            if (CollectionUtils.isEmpty(params)) {
                //参数为空
                outParamEmptyError(result);
                return result;
            }
            //接收参数
            Integer customerId = params.getInteger("customerId");
            String oldPassword = params.getString("oldPassword");
            String password = params.getString("password");
            String rePassword = params.getString("rePassword");
            String userId = params.getString("userId");

            //校验参数
            if (StringUtils.isBlank(password) || StringUtils.isBlank(rePassword) || StringUtils.isBlank(userId) || StringUtils.isBlank(oldPassword)) {
                outParamEmptyError(result);
                return result;
            }            
            if(!password.equals(rePassword)){
            	outError(result, "两次输入的密码不一致!");
            	return result;
            }
            
            //根据用户ID和客户ID查询客户用户记录
//            CustomerUser customerUser = customerUserapiservice.findCustomerUserByUserIdAndCustomerId(userId, customerId);
            CustomerUser customerUser = dao.findCustomerUserByUserIdAndCustomerId(userId, customerId);
            if (customerUser == null) {
    			outError(result, "用户不存在");
    			return result;
    		} else {
    			if (!PasswordProvider.encrypt(oldPassword).equals(customerUser.getPassword())) {
    				outError(result, "旧密码错误");
    				return result;
    			}
    			//修改用户登录密码
//                customerUserapiservice.updateUserPwd(customerUser.getAccount(), customerId, PasswordProvider.encrypt(rePassword));
                dao.updateUserPwd(customerUser.getAccount(), customerId, PasswordProvider.encrypt(rePassword));
                outSuccess(result, "修改密码成功！");
    		}
        } catch (Exception e) {
        	e.printStackTrace();
            outError(result, "修改密码失败！系统繁忙...");
        }
        return result;
	}

}
