package com.niuka.user.rpc;

import com.niuka.common.exception.DaoException;
import com.niuka.common.model.Pagination;
import com.niuka.common.model.Result;
import com.niuka.common.service.mybatis.Service;
import com.niuka.user.model.User;
import com.niuka.user.model.UserRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 管理员服务接口
 * 
 * @author hewei
 */
public interface UserJtaService extends Service<User, Integer> {
	

	/**
	 * 添加用户与角色
	 * @param user
	 * @param userRole
	 * @return
	 */
	@Transactional(rollbackFor = DaoException.class)
	public int addUserRole(User user, UserRole userRole)throws DaoException;

	/**
	 * 删除用户与用户权限管理
	 * @param userId
	 * @return
	 */
	public boolean deleteUserAndRole(int userId,int appId) throws  DaoException;


}
