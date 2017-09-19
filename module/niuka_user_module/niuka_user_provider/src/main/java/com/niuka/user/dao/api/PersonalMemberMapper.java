package com.niuka.user.dao.api;

import com.niuka.common.dao.mybatis.Dao;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;

import org.apache.ibatis.annotations.*;

/**
 * Created by admin on 2017/9/7.
 */
public interface PersonalMemberMapper extends Dao<PersonalMember, Integer> {

	/**
     * 根据会员ID查询用户信息
     * @param userId
	 * @param customerId 
     * @return
     */
	public PersonalMember findMemberByUserIdAndCustomerId(@Param("userId") Integer userId, @Param("customerId") Integer customerId);

	/**
	 * 根据会员ID修改绑定手机
	 * @param personalId
	 * @param newPhone
	 * @return
	 */
	public int updateBindPhone(@Param("personalId") String personalId, @Param("newPhone") String newPhone);

	/**
	 * 修改用户支付密码
	 * @param personalId
	 * @param payPassword
	 * @return
	 */
	public int updatePayPassword(@Param("personalId") String personalId, @Param("payPassword") String payPassword);

	/**
	 * 根据会员ID查询会员信息
	 * @param memberId
	 * @return
	 */
	public PersonalMember queryMemberInfoById(@Param("memberId") Integer memberId);

}
