package com.niuka.user.service;

import com.niuka.common.annotation.LoginUser;
import com.niuka.common.annotation.TokenManager;
import com.niuka.common.model.RpcPermission;
import com.niuka.common.model.RpcUser;
import com.niuka.common.util.StringUtils;
import com.niuka.user.rpc.AuthenticationRpcService;
import com.niuka.user.rpc.PermissionService;
import com.niuka.user.rpc.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


@Service("authenticationrpcservice")
public class AuthenticationRpcServiceImpl implements AuthenticationRpcService {

	@Resource
	private PermissionService permissionservice;
	@Resource
	private UserService userservice;
	@Resource
	private TokenManager tokenManager;

	@Override
	public boolean validate(String token) {
		return tokenManager.validate(token) != null;
	}
	
	@Override
	public RpcUser findAuthInfo(String token) {
		LoginUser user = tokenManager.validate(token);
		if (user != null) {
			return new RpcUser(user.getAccount());
		}
		return null;
	}
	
	@Override
	public List<RpcPermission> findPermissionList(String token, String appCode) {
		if (StringUtils.isBlank(token)) {
			return permissionservice.findListById(appCode, null);
		}
		else {
			LoginUser user = tokenManager.validate(token);
			if (user != null) {
				return permissionservice.findListById(appCode, user.getUserId());
			}
			else {
				return new ArrayList<RpcPermission>(0);
			}
		}
	}
}
