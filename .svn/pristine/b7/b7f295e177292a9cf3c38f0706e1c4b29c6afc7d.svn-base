package com.niuka.user.dao;

import java.util.List;
import java.util.Set;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.common.model.Pagination;
import com.niuka.user.model.App;
import org.apache.ibatis.annotations.Param;



/**
 * 应用持久化接口
 * 
 * @author hewei
 */
public interface AppDao extends Dao<App, Integer> {
	
	public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);
	
	public List<App> findPaginationByName(@Param("name") String name, Pagination<App> p);
	
	public App findByCode(@Param("code") String code);
	
	public List<App> findByUserId(@Param("isEnable") Boolean isEnable, @Param("userId") Integer userId);
	
	public Set<String> findAppCodeByUserId(@Param("isEnable") Boolean isEnable, @Param("userId") Integer userId);
}
