package com.niuka.user.rpc;

import com.niuka.common.exception.DaoException;
import com.niuka.common.model.Pagination;
import com.niuka.common.model.Result;
import com.niuka.common.service.mybatis.Service;
import com.niuka.user.model.Role;
import com.niuka.user.model.User;
import com.niuka.user.model.UserRole;

import java.util.List;



/**
 * 管理员服务接口
 * 
 * @author hewei
 */
public interface UserService extends Service<User, Integer> {
	
	/**
	 * 登录
	 * 
	 * @param appCode
	 *            应用编码
	 * @param account
	 *            登录名
	 * @param password
	 *            密码
	 * @return 管理员ID和应用编码集合Map
	 */
	public Result login(String ip, String appCode, String account, String password);
	
	/**
	 * 启用禁用操作
	 * @param isEnable 是否启用
	 * @param idList 管理员ID集合
	 * @return
	 */
	public void enable(Boolean isEnable, List<Integer> idList);
	
	/**
	 * 重置密码
	 * @param password 初始化密码(已加密)
	 * @param idList 
	 */
	public void resetPassword(String password, List<Integer> idList);

	/**
	 * 根据登录名和应用ID查询分页列表
	 * @param account 登录名
	 * @param appId 应用ID
	 * @return
	 */
	public Pagination<User> findPaginationByAccount(String account, Integer appId, Pagination<User> p);
	
	/**
	 * 根据登录名和应用ID查询
	 * @param account 登录名
	 * @param appId 应用ID
	 * @return
	 */
	public User findByAccount(String account);
	
	/**
	 * 更新密码
	 * 
	 * @param id
	 *            用户ID
	 * @param newPassword
	 *            新密码
	 * @return
	 */
	public void updatePassword(Integer id, String newPassword);


	/**
	 * 添加用户与角色
	 * @param user
	 * @param userRole
	 * @return
	 */
	public int addUserRole(User user, UserRole userRole)throws DaoException;

}
