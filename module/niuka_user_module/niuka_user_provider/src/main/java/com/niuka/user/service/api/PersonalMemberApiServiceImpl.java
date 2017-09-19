package com.niuka.user.service.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niuka.common.constant.ConstantMessage;
import com.niuka.common.exception.DaoException;
import com.niuka.common.model.Criteria;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.service.mybatis.impl.ServiceImpl;
import com.niuka.common.util.ClassUtil;
import com.niuka.common.util.Common;
import com.niuka.common.util.MD5;
import com.niuka.common.util.ValidateUtils;
import com.niuka.user.dao.UserDao;
import com.niuka.user.dao.api.PersonalMemberMapper;
import com.niuka.user.model.PersonalMember;
import com.niuka.user.model.User;
import com.niuka.user.rpc.api.PersonalMemberApiService;
import com.niuka.user.rpc.api.UserApiService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/9/10.
 */
@Service("memberapiservice")
public class PersonalMemberApiServiceImpl extends ServiceImpl<PersonalMemberMapper, PersonalMember, Integer>  implements PersonalMemberApiService   {

	@Autowired
	public void setDao(PersonalMemberMapper dao) {
		this.dao = dao;
	}

	@Override
	public PersonalMember findMemberByUserIdAndCustomerId(Integer userId, Integer customerId) {
		return dao.findMemberByUserIdAndCustomerId(userId, customerId);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public Integer add(PersonalMember member) throws DaoException {
		return dao.insert(member);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public void updateBindPhone(String personalId, String newPhone) throws DaoException {
		dao.updateBindPhone(personalId, newPhone);
	}

	@Override
	@Transactional(rollbackFor = DaoException.class)
	public void updatePayPassword(String personalId, String payPassword) throws DaoException {
		dao.updatePayPassword(personalId, payPassword);
	}

	@Override
	public Map<String, Object> showMemberInfo(ExtendMap<String, Object> params, Map<String, Object> result, HttpServletRequest request) {
		try {
			// 检查参数
			if (CollectionUtils.isEmpty(params)) {
				// 参数为空
				outParamEmptyError(result);
				return result;
			}

			// 接收参数
			Integer memberId = params.getInteger("memberId");
			
			//业务处理
			PersonalMember member = dao.queryMemberInfoById(memberId);
			
			//输出参数
			Map<String, Object> outPutParam = new HashMap<String, Object>();
			outPutParam.put("headImg", member.getHeadImg());
			outPutParam.put("phone", member.getPhone());
			outPutParam.put("nickName", member.getNickName());
			
			// 输出
			outSuccess(result, outPutParam);
		} catch (Exception e) {
			e.printStackTrace();
			outError(result, "会员信息查询失败失败！系统繁忙...");
		}
		return result;
	}

}
