package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.common.model.RpcPermission;
import com.niuka.user.model.Permission;
import org.apache.ibatis.annotations.Param;



/**
 * 权限持久化接口
 * 
 * @author hewei
 */
public interface PermissionDao extends Dao<Permission, Integer> {
	
	public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);
	
	public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

	public List<Permission> findByName(@Param("name") String name, @Param("appId") Integer appId, @Param("isEnable") Boolean isEnable);
	
	public int deleteByAppIds(@Param("idList") List<Integer> idList);
	
	public List<RpcPermission> findListById(@Param("appCode") String appCode, @Param("userId") Integer userId);
}
