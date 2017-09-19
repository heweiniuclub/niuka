package com.niuka.user.service.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niuka.common.constant.ConstantMessage;
import com.niuka.common.model.Criteria;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.provider.PasswordProvider;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.common.util.ClassUtil;
import com.niuka.common.util.Common;
import com.niuka.common.util.MD5;
import com.niuka.common.util.MD5Util;
import com.niuka.common.util.ValidateUtils;
import com.niuka.user.dao.UserDao;
import com.niuka.user.dao.api.OauthLoginMapper;
import com.niuka.user.model.OauthLogin;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;
import com.niuka.user.rpc.UserService;
import com.niuka.user.rpc.api.OauthLoginApiService;
import com.niuka.user.rpc.api.PersonalMemberApiService;
import com.niuka.user.rpc.api.UserApiService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/9/10.
 */
@Service("oauthLoginapiservice")
public class OauthLoginApiServiceImpl extends ServiceImpl<OauthLoginMapper, OauthLogin, Integer>  implements OauthLoginApiService   {
	
	@Autowired
	public void setDao(OauthLoginMapper dao) {
		this.dao = dao;
	}

	@Override
	public OauthLogin findOauthLoginByCustomerId(Integer customerId,String oauthName, String oauthId) {
		return dao.findOauthLoginByCustomerId(customerId, oauthId, oauthName);
	}

	@Override
	public OauthLogin queryUserByOauthId(String oauthId) {
		return dao.queryUserByOauthId(oauthId);
	}


}
