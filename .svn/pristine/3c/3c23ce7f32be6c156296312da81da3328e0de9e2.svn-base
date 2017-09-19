package com.niuka.user.dao.api;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.OauthLogin;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;

import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/9/7.
 */
public interface OauthLoginMapper extends Dao<OauthLogin, Integer> {

	/**
	 * 根据客户ID和身份ID查询权限登录记录是否存在
	 * @param customerId
	 * @param oauthId
	 * @param oauthName
	 * @return
	 */
	OauthLogin findOauthLoginByCustomerId(@Param("customerId") Integer customerId, @Param("oauthId") String oauthId, @Param("oauthName") String oauthName);

	/**
	 * 根据快捷登录第三方唯一标识查询权限登录记录
	 * @param oauthId
	 * @return
	 */
	OauthLogin queryUserByOauthId(@Param("oauthId") String oauthId);

}
