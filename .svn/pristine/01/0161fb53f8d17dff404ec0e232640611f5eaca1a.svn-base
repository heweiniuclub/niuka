package com.niuka.user.rpc;

import com.niuka.common.model.Pagination;
import com.niuka.common.service.mybatis.Service;
import com.niuka.user.model.Role;

import java.util.List;


/**
 * 角色服务接口
 * 
 * @author hewei
 */
public interface RoleService extends Service<Role, Integer> {
	
	/**
	 * 启用禁用操作
	 * @param isEnable 是否启用
	 * @param idList 角色ID集合
	 * @return
	 */
	public void enable(Boolean isEnable, List<Integer> idList);
	
	/**
	 * 根据角色名称和应用ID查询分页列表
	 * @param name 角色名称
	 * @param appId 应用ID
	 * @return
	 */
	public Pagination<Role> findPaginationByName(String name, Integer appId, Pagination<Role> p);
	
	/**
	 * 查询应用可用角色
	 * @param isEnable 是否启用
	 * @param appId 应用ID
	 * @return
	 */
	public List<Role> findByAppId(Boolean isEnable, Integer appId);
	
	/**
	 * 删除某个应用下的所有角色
	 * @param idList 应用ID集合
	 * @return
	 */
	public void deleteByAppIds(List<Integer> idList);

	/**
	 * 查询所有的角色信息在同一个app内
	 *
	 * @param userId
	 * @return
	 */
	public List<Role> queryRoleListByAppId(Integer userId);
}
