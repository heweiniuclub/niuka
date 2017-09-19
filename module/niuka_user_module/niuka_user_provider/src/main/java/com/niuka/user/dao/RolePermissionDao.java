package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.RolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * 角色权限映射持久化接口
 * 
 * @author hewei
 */
public interface RolePermissionDao extends Dao<RolePermission, Integer> {
	
	public List<RolePermission> findByRoleId(@Param("roleId") Integer roleId);
	
	public int deleteByPermissionIds(@Param("idList") List<Integer> idList);
	
	public int deleteByRoleIds(@Param("idList") List<Integer> idList);
	
	public int deleteByAppIds(@Param("idList") List<Integer> idList);
}
