package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.common.model.Pagination;
import com.niuka.user.model.User;
import org.apache.ibatis.annotations.Param;



/**
 * 管理员持久化接口
 * 
 * @author hewei
 */
public interface UserDao extends Dao<User, Integer> {
	
	public int enable(@Param("isEnable") Boolean isEnable, @Param("idList") List<Integer> idList);
	
	public int resetPassword(@Param("password") String password, @Param("idList") List<Integer> idList);

	public List<User> findPaginationByAccount(@Param("account") String account, @Param("appId") Integer appId, Pagination<User> p);
	
	public User findByAccount(@Param("account") String account);
}
