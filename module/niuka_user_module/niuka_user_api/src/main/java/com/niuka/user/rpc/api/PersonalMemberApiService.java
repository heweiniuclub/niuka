package com.niuka.user.rpc.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.niuka.common.exception.DaoException;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.service.mybatis.Service;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;

/**
 * Created by admin on 2017/9/10.
 */
public interface PersonalMemberApiService extends Service<PersonalMember, Integer> {

	/**
	 * 根据userId查询会员消息
	 * @param userId
	 * @param customerId 
	 * @return
	 */
	public PersonalMember findMemberByUserIdAndCustomerId(Integer userId, Integer customerId);

	/**
	 * 添加会员信息
	 * @param member
	 * @return
	 */
	@Transactional
	public Integer add(PersonalMember member) throws DaoException;

	/**
	 * 根据会员ID修改绑定手机
	 * @param personalId
	 * @param newPhone
	 */
	@Transactional
	public void updateBindPhone(String personalId, String newPhone) throws DaoException;

	/**
	 * 修改用户支付密码
	 * @param personalId
	 * @param encrypt
	 */
	@Transactional
	public void updatePayPassword(String personalId, String payPassword) throws DaoException;

	/**
	 * 根据会员ID查询会员信息
	 * @param params
	 * @param result
	 * @param request
	 * @return
	 */
	public Map<String, Object> showMemberInfo(ExtendMap<String, Object> params, Map<String, Object> result, HttpServletRequest request);

}
