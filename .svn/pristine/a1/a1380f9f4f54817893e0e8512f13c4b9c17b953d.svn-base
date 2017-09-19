package com.niuka.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.niuka.common.model.RpcPermission;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.PermissionDao;
import com.niuka.user.model.Permission;
import com.niuka.user.rpc.AppService;
import com.niuka.user.rpc.PermissionJmsService;
import com.niuka.user.rpc.PermissionService;
import com.niuka.user.rpc.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("permissionservice")
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, Permission, Integer> implements PermissionService {

	@Resource
	private RolePermissionService rolepermissionservice;
	@Resource
	private PermissionService permissionservice;
	@Resource
	private AppService appservice;
	@Resource
	private PermissionJmsService permissionjmsservice;

	@Autowired
	public void setDao(PermissionDao dao) {
		this.dao = dao;
	}

	public void save(Permission t) {
		super.save(t);
		// JMS通知权限变更
		permissionjmsservice.send(appservice.get(t.getAppId()).getCode());
	}

	public List<Permission> findByName(String name, Integer appId, Boolean isEnable) {
		return dao.findByName(name, appId, isEnable);
	}

	@Transactional
	public void deletePermission(Integer id, Integer appId) {
		List<Integer> idList = new ArrayList<Integer>();

		List<Permission> list = permissionservice.findByName(null, appId, null);
		loopSubList(id, idList, list);
		idList.add(id);

		rolepermissionservice.deleteByPermissionIds(idList);

		verifyRows(dao.deleteById(idList), idList.size(), "权限数据库删除失败");
	}

	// 递归方法，删除子权限
	protected void loopSubList(Integer id, List<Integer> idList, List<Permission> list) {
		for (Permission p : list) {
			if (id.equals(p.getParentId())) {
				idList.add(p.getId());
				loopSubList(p.getId(), idList, list);
			}
		}
	}

	public void deleteByAppIds(List<Integer> idList) {
		dao.deleteByAppIds(idList);
	}

	public List<RpcPermission> findListById(String appCode, Integer userId) {
		return dao.findListById(appCode, userId);
	}
}
