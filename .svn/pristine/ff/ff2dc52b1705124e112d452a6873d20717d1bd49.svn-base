package com.niuka.user.service;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.niuka.common.model.Pagination;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.AppDao;
import com.niuka.user.model.App;

import com.niuka.user.rpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("appservice")
public class AppServiceImpl extends ServiceImpl<AppDao, App, Integer> implements AppService {

	@Resource
	private UserService userservice;
	@Resource
	private RoleService roleservice;
	@Resource
	private PermissionService permissionservice;
	@Resource
	private UserRoleService userroleservice;
	@Resource
	private UserAppService userappservice;
	@Resource
	private RolePermissionService rolepermissionservice;

	@Autowired
	public void setDao(AppDao dao) {
		this.dao = dao;
	}

	public void enable(Boolean isEnable, List<Integer> idList) {
		verifyRows(dao.enable(isEnable, idList), idList.size(), "应用数据库更新失败");
	}

	public void save(App t) {
		super.save(t);
	}

	public List<App> findByAll(String name) {
		return dao.findPaginationByName(name, null);
	}

	public Pagination<App> findPaginationByName(String name, Pagination<App> p) {
		dao.findPaginationByName(name, p);
		return p;
	}

	public App findByCode(String code) {
		return dao.findByCode(code);
	}

	public List<App> findByUserId(Boolean isEnable, Integer userId) {
		return dao.findByUserId(isEnable, userId);
	}

	@Transactional
	public void deleteById(List<Integer> idList) {
		rolepermissionservice.deleteByAppIds(idList);
		userroleservice.deleteByAppIds(idList);
		userappservice.deleteByAppIds(idList);
		permissionservice.deleteByAppIds(idList);
		roleservice.deleteByAppIds(idList);
		verifyRows(dao.deleteById(idList), idList.size(), "应用数据库删除失败");
	}

	public Set<String> findAppCodeByUserId(Boolean isEnable, Integer userId) {
		return dao.findAppCodeByUserId(isEnable, userId);
	}
}
