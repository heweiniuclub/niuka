package com.niuka.api.server.controller.user;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuka.api.server.controller.base.BaseController;
import com.niuka.api.server.controller.param.input.bindphone.BindPhoneRequest;
import com.niuka.api.server.controller.param.input.bindphone.BindPhoneVO;
import com.niuka.api.server.controller.param.input.bindphone.CheckBindPhoneRequest;
import com.niuka.api.server.controller.param.input.bindphone.CheckBindPhoneVO;
import com.niuka.api.server.controller.param.input.forgetpassword.ForgetPwdRequest;
import com.niuka.api.server.controller.param.input.forgetpassword.ForgetPwdVO;
import com.niuka.api.server.controller.param.input.login.LoginRequest;
import com.niuka.api.server.controller.param.input.msg.SendMsgRequest;
import com.niuka.api.server.controller.param.input.msg.SendMsgVO;
import com.niuka.api.server.controller.param.input.msgcode.MsgCodeRequest;
import com.niuka.api.server.controller.param.input.msgcode.MsgCodeVO;
import com.niuka.api.server.controller.param.input.paypassword.PayPasswordRequest;
import com.niuka.api.server.controller.param.input.paypassword.PayPasswordVO;
import com.niuka.api.server.controller.param.input.register.RegisterRequest;
import com.niuka.api.server.controller.param.input.updatebindphone.UpdateBindPhoneRequest;
import com.niuka.api.server.controller.param.input.updatebindphone.UpdateBindPhoneVO;
import com.niuka.api.server.controller.param.input.updatepwd.UpdatePwdRequest;
import com.niuka.api.server.controller.param.input.updatepwd.UpdatePwdVO;
import com.niuka.common.cache.RedisCache;
import com.niuka.common.model.AbstractBaseFactory;
import com.niuka.common.model.ExtendMap;
import com.niuka.common.provider.IdProvider;
import com.niuka.common.util.ClassUtil;
import com.niuka.common.util.OutputUtil;
import com.niuka.customer.rpc.api.CustomerUserApiService;
import com.niuka.customer.rpc.api.CustomerUserJtaApiService;
import com.niuka.user.rpc.api.UserApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hewei
 */
@Api(tags = "用户")
@Controller
@RequestMapping("/api/user")
public class UserController extends BaseController {


	@Resource
	private RedisCache<String> redisCache;
	
	@Resource
	private UserApiService userapiservice;
	
	@Resource
	private CustomerUserApiService customerUserapiservice;

	@Resource
	private CustomerUserJtaApiService customerUserJtaApiService;


    /**
     * 修改登录密码
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public Map<String, Object> updatePassword(String paramStr) {
        LOG.info("updatePassword---------------------------");
        UpdatePwdRequest updatePwdRequest = com.alibaba.fastjson.JSON.parseObject(paramStr, UpdatePwdRequest.class);
        Map<String, Object> result = null;
        try {
        	UpdatePwdVO updatePwdVO = updatePwdRequest.getData();
        	ExtendMap<String, Object> params = AbstractBaseFactory.createMap(updatePwdVO);
        	params.put("customerId", updatePwdRequest.getCustomerId());
			result = userapiservice.updatePassword(params);
			// result = customerUserJtaApiService.updatePassword(params);
            System.out.println(111);
//            checkResult(result);
        } catch (Exception e) {
        	e.printStackTrace();
            LOG.error("修改失败！", e);
            outError(result, "修改密码失败，系统繁忙...");
        }
        return result;
    }

}