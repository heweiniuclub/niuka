package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.UserRole;
import org.apache.ibatis.annotations.Param;



/**
 * 管理员角色映射持久化接口
 * 
 * @author hewei
 */
public interface UserRoleDao extends Dao<UserRole, Integer> {

	public UserRole findByUserRoleId(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

	public int deleteByRoleIds(@Param("idList") List<Integer> idList);

	public int deleteByUserIds(@Param("idList") List<Integer> idList, @Param("appId") Integer appId);

	public int deleteByAppIds(@Param("idList") List<Integer> idList);
	
	public int deleteForChangeApp(@Param("userId") Integer userId, @Param("idList") List<Integer> idList);
}
