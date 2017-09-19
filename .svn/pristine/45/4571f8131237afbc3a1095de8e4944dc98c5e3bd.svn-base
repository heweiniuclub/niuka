package com.niuka.user.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.UserAppDao;
import com.niuka.user.model.UserApp;
import com.niuka.user.rpc.UserAppService;
import com.niuka.user.rpc.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userappservice")
public class UserAppServiceImpl extends ServiceImpl<UserAppDao, UserApp, Integer> implements UserAppService {

	@Resource
	private UserRoleService userroleservice;
	
	@Autowired
	public void setDao(UserAppDao dao) {
		this.dao = dao;
	}
	
	@Transactional
	public void allocate(Integer userId, List<Integer> idList, List<UserApp> list) {
		userroleservice.deleteForChangeApp(userId, idList);
		dao.deleteByUserIds(Arrays.asList(userId));
		super.save(list);
	}
	
	public UserApp findByUserAppId(Integer userId, Integer roleId) {
		return dao.findByUserAppId(userId, roleId);
	}
	
	public void deleteByUserIds(List<Integer> idList) {
		dao.deleteByUserIds(idList);
	}
	
	public void deleteByAppIds(List<Integer> idList) {
		dao.deleteByAppIds(idList);
	}
}
