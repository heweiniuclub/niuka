package com.niuka.user.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.RolePermissionDao;
import com.niuka.user.model.RolePermission;
import com.niuka.user.rpc.AppService;
import com.niuka.user.rpc.PermissionJmsService;
import com.niuka.user.rpc.RolePermissionService;
import com.niuka.user.rpc.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("rolepermissionservice")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionDao, RolePermission, Integer> implements RolePermissionService {
	
	@Resource
	private RoleService roleservice;
	@Resource
	private AppService appservice;
	@Resource
	private PermissionJmsService permissionjmsservice;

	@Autowired
	public void setDao(RolePermissionDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void allocate(Integer roleId, List<RolePermission> list) {
		dao.deleteByRoleIds(Arrays.asList(roleId));
		super.save(list);
		// JMS通知权限变更
		permissionjmsservice.send(appservice.get(roleservice.get(roleId).getAppId()).getCode());
	}

	public List<RolePermission> findByRoleId(Integer roleId) {
		return dao.findByRoleId(roleId);
	}

	public void deleteByPermissionIds(List<Integer> idList) {
		dao.deleteByPermissionIds(idList);
	}
	
	public void deleteByRoleIds(List<Integer> idList) {
		dao.deleteByRoleIds(idList);
	}
	
	public void deleteByAppIds(List<Integer> idList) {
		dao.deleteByAppIds(idList);
	}
}
