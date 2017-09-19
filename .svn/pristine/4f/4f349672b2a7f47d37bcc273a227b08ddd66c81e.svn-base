package com.niuka.user.rpc.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.niuka.common.model.ExtendMap;
import com.niuka.common.service.mybatis.Service;
import com.niuka.user.model.OauthLogin;
import com.niuka.user.model.User;

/**
 * Created by admin on 2017/9/10.
 */
public interface OauthLoginApiService extends Service<OauthLogin, Integer> {

	/**
	 * 根据客户ID和身份ID查询权限登录记录是否存在
	 * @param customerId
	 * @param oauthName
	 * @param oauthId
	 * @return
	 */
	OauthLogin findOauthLoginByCustomerId(Integer customerId, String oauthName, String oauthId);

	/**
	 * 根据快捷登录第三方唯一标识查询权限登录记录
	 * @param openId
	 * @return
	 */
	OauthLogin queryUserByOauthId(String oauthId);

}
