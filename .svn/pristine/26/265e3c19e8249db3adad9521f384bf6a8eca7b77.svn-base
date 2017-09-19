package com.niuka.user.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.niuka.common.enums.TrueFalseEnum;
import com.niuka.common.exception.DaoException;
import com.niuka.common.model.Pagination;
import com.niuka.common.model.Result;
import com.niuka.common.model.ResultCode;
import com.niuka.common.provider.PasswordProvider;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.user.dao.UserDao;
import com.niuka.user.model.Role;
import com.niuka.user.model.User;
import com.niuka.user.model.UserRole;
import com.niuka.user.rpc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


@Service("userservice")
public class UserServiceImpl extends ServiceImpl<UserDao, User, Integer> implements UserService {
	
	@Resource
	private UserAppService userappservice;
	@Resource
	private UserRoleService userroleservice;
	@Resource
	private AppService appservice;

	@Resource
	private RoleService roleservice;


	@Autowired
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	public Result login(String ip, String appCode, String account, String password) {
		Result result = Result.createSuccessResult();
		User user = findByAccount(account);
		if (user == null) {
			result.setCode(ResultCode.ERROR).setMessage("登录名不存在");
		}
		else if (!user.getPassword().equals(password)) {
			result.setCode(ResultCode.ERROR).setMessage("密码不正确");
		}
		else if (TrueFalseEnum.FALSE.getValue().equals(user.getIsEnable())) {
			result.setCode(ResultCode.ERROR).setMessage("已被管理员禁用");
		}
		else {
			Set<String> set = appservice.findAppCodeByUserId(TrueFalseEnum.TRUE.getValue(), user.getId());
			if (CollectionUtils.isEmpty(set)) {
				result.setCode(ResultCode.ERROR).setMessage("不存在可操作应用");
			}
			else if (!set.contains(appCode)) {
				result.setCode(ResultCode.ERROR).setMessage("没有应用操作权限");
			}
			else {
				user.setLastLoginIp(ip);
				user.setLoginCount(user.getLoginCount() + 1);
				user.setLastLoginTime(new Date());
				dao.update(user);
				result.setData(user);
			}
		}
		return result;
	}

	public void enable(Boolean isEnable, List<Integer> idList) {
		verifyRows(dao.enable(isEnable, idList), idList.size(), "管理员数据库更新失败");
	}
	
	public void save(User t) {
		super.save(t);
	}

	public void resetPassword(String password, List<Integer> idList) {
		verifyRows(dao.resetPassword(password, idList), idList.size(), "管理员密码数据库重置失败");
	}

	public Pagination<User> findPaginationByAccount(String account, Integer appId, Pagination<User> p) {
		dao.findPaginationByAccount(account, appId, p);
		return p;
	}
	
	public User findByAccount(String account) {
		return dao.findByAccount(account);
	}
	
	@Transactional
	public void deleteById(List<Integer> idList) {
		userappservice.deleteByUserIds(idList);
		userroleservice.deleteByUserIds(idList, null);
		verifyRows(dao.deleteById(idList), idList.size(), "管理员数据库删除失败");
	}

	@Override
	public void updatePassword(Integer id, String newPassword) {
		User user = get(id);
		user.setPassword(PasswordProvider.encrypt(newPassword));
		update(user);
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


}
