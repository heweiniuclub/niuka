package com.niuka.user.service;

import com.niuka.common.exception.DaoException;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.UserDao;
import com.niuka.user.model.User;
import com.niuka.user.model.UserRole;
import com.niuka.user.rpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("userJtaService")
public class UserJtaServiceImpl extends ServiceImpl<UserDao, User, Integer> implements UserJtaService {
	

	@Resource
	private UserRoleService userroleservice;

	@Autowired
	public void setDao(UserDao dao) {
		this.dao = dao;
	}


	/**
	 * 添加用户与角色
	 *
	 * @param user
	 * @param userRole
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = DaoException.class)
	public int addUserRole(User user, UserRole userRole)throws DaoException {
		int insert = dao.insert(user);
		userRole.setUserId(user.getId());
		userroleservice.save(userRole);
		return insert;
	}


	/**
	 * 删除用户与用户权限管理
	 *
	 * @param userId
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = DaoException.class)
	public boolean deleteUserAndRole(int userId,int appId) throws  DaoException {
		List<Integer> ids = new ArrayList<Integer>() ;
		ids.add(userId);

		// 删除角色用户关系
		userroleservice.deleteByUserIds(ids,appId);

		// 删除用户信息
		dao.deleteById(ids);

		return true;
	}


}
