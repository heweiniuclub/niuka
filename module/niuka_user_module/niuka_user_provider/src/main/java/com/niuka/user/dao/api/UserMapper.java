package com.niuka.user.dao.api;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;

import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/9/7.
 */
public interface UserMapper extends Dao<User, Integer> {

    /**
     * 检查用户是否已经注册
     * @param username
     * @param customerId 
     * @return
     */
	public int checkIsRegister(@Param("username") String username, @Param("customerId") Integer customerId);

    /**
     * 根据账号查询用户信息
     * @param username
     * @param password
     * @return
     */
	public User findUserByAccount(@Param("username") String username);

	/**
	 * 根据账号密码和客户ID查询是否已经注册
	 * @param username
	 * @param password
	 * @param customerId
	 * @return
	 */
	public int checkPhoneAndPasswordExist(@Param("username") String username, @Param("password") String password, @Param("customerId") Integer customerId);

}
