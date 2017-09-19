package com.niuka.api.server.controller.user;


import com.alibaba.fastjson.JSON;
import com.niuka.api.server.controller.base.BaseController;
import com.niuka.api.server.controller.param.input.bindphone.BindPhoneRequest;
import com.niuka.api.server.controller.param.input.bindphone.BindPhoneVO;
import com.niuka.api.server.controller.param.input.login.LoginRequest;
import com.niuka.api.server.controller.param.input.member.ShowMemberInfoRequest;
import com.niuka.api.server.controller.param.input.member.ShowMemberInfoVO;
import com.niuka.api.server.controller.param.input.register.RegisterRequest;
import com.niuka.api.server.controller.param.output.MemberVO;
import com.niuka.common.cache.RedisCache;
import com.niuka.common.model.AbstractBaseFactory;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.model.Token;
import com.niuka.common.provider.IdProvider;
import com.niuka.common.util.ClassUtil;
import com.niuka.common.util.OutputUtil;
import com.niuka.user.rpc.api.PersonalMemberApiService;
import com.niuka.user.rpc.api.UserApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiangtao
 */
@Api(tags = "用户")
@Controller
@RequestMapping("/api/member")
public class MemberController extends BaseController {


	@Resource
	private RedisCache<String> redisCache;
	
	@Resource
	private PersonalMemberApiService memberApiService;
	
	/**
	 * 查询会员基本信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showMemberInfo", method = RequestMethod.POST)
	public Map<String, Object> showMemberInfo(String paramStr) {
		LOG.info("查询会员基本信息.....................");
		ShowMemberInfoRequest showMemberInfoRequest = JSON.parseObject(paramStr, ShowMemberInfoRequest.class);
		Map<String, Object> result = new HashMap<>();
		try {
			ShowMemberInfoVO showMemberInfoVO = showMemberInfoRequest.getData();
			ExtendMap<String, Object> params = AbstractBaseFactory.createMap(showMemberInfoVO);
			params.put("customerId", showMemberInfoRequest.getCustomerId());
			return memberApiService.showMemberInfo(params, result, request);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("查询会员基本信息失败!", e);
			outError(result, "查询会员基本信息失败!");
		}
		return result;
	}
	
//	/**
//     * 修改用户资料
//     *
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/updateMemberInfo", method = RequestMethod.POST)
//	public Map<String, Object> updateMemberInfo(String paramStr) {
//		LOG.info("修改用户资料.....................");
//		BindPhoneRequest bindPhoneRequest = JSON.parseObject(paramStr, BindPhoneRequest.class);
//		Map<String, Object> result = new HashMap<>();
//		try {
//			BindPhoneVO bindPhoneVO = bindPhoneRequest.getData();
//			ExtendMap<String, Object> params = AbstractBaseFactory.createMap(bindPhoneVO);
//			params.put("customerId", bindPhoneRequest.getCustomerId());
//			return memberApiService.updateMemberInfo(params, result, request);
//		} catch (Exception e) {
//			e.printStackTrace();
//			LOG.error("修改用户资料失败!", e);
//			outError(result, "修改用户资料失败!");
//		}
//		return result;
//	}
	
}