package com.niuka.user.dao;

import java.util.List;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.UserApp;
import org.apache.ibatis.annotations.Param;



/**
 * 管理员角色映射持久化接口
 * 
 * @author hewei
 */
public interface UserAppDao extends Dao<UserApp, Integer> {

	public UserApp findByUserAppId(@Param("userId") Integer userId, @Param("appId") Integer appId);

	public int deleteByAppIds(@Param("idList") List<Integer> idList);

	public int deleteByUserIds(@Param("idList") List<Integer> idList);
}
