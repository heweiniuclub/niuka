package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.common.model.Pagination;
import com.niuka.user.model.Role;
import org.apache.ibatis.annotations.Param;


/**
 * 角色持久化接口
 * 
 * @author hewei
 */
public interface RoleDao extends Dao<Role, Integer> {

	public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);

	public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

	public List<Role> findPaginationByName(@Param("name") String name, @Param("isEnable") Boolean isEnable,
                                           @Param("appId") Integer appId, Pagination<Role> p);

	public int deleteByAppIds(@Param("idList") List<Integer> idList);


	/**
	 * 根据userid 获取app下面所有的角色信息
	 * @param userId
	 * @return
	 */
	List<Role>  queryRoleListByUserId(int userId);
}
