package com.niuka.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.niuka.common.model.Pagination;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.RoleDao;
import com.niuka.user.model.Role;
import com.niuka.user.rpc.RolePermissionService;
import com.niuka.user.rpc.RoleService;
import com.niuka.user.rpc.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("roleservice")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role, Integer> implements RoleService {

	@Resource
	private UserRoleService userRoleService;
	@Resource
	private RolePermissionService rolePermissionService;

	@Autowired
	public void setDao(RoleDao dao) {
		this.dao = dao;
	}

	public void enable(Boolean isEnable, List<Integer> idList) {
		verifyRows(dao.enable(isEnable, idList), idList.size(), "角色数据库更新失败");
	}

	public void save(Role t) {
		super.save(t);
	}

	public Pagination<Role> findPaginationByName(String name, Integer appId, Pagination<Role> p) {
		dao.findPaginationByName(name, null, appId, p);
		return p;
	}

	public List<Role> findByAppId(Boolean isEnable, Integer appId) {
		if (appId == null)
			return new ArrayList<Role>(0);
		return dao.findPaginationByName(null, isEnable, appId, null);
	}

	@Transactional
	public void deleteById(List<Integer> idList) {
		userRoleService.deleteByRoleIds(idList);
		rolePermissionService.deleteByRoleIds(idList);
		verifyRows(dao.deleteById(idList), idList.size(), "角色数据库删除失败");
	}

	public void deleteByAppIds(List<Integer> idList) {
		dao.deleteByAppIds(idList);
	}


	/**
	 * 查询所有的角色信息在同一个app内
	 *
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleListByAppId(Integer userId) {

		return dao.queryRoleListByUserId(userId);
	}
}


