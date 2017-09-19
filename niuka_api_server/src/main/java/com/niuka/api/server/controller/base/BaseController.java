package com.niuka.api.server.controller.base;

import com.niuka.api.server.controller.constant.Constant;
import com.niuka.common.util.DesCrypt;
import com.niuka.common.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by lf on 2016-9-6 14:49:18.
 */
@Controller
public class BaseController {
	protected static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpServletResponse response;


	
	/**
	 * 输出成功的结果
	 *
	 * @param obj
	 *            输出的map
	 * @param vo
	 *            输出的数据
	 */
	protected void putSuccess(Map<String, Object> obj, Object vo) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);

		// 结果
		obj.put(Constant.MSG_RESULT, DesCrypt.encode(String.valueOf(vo)));
		ResponseUtil.writeJSON(response, obj);
	}

	/**
	 * 输出空结果
	 *
	 * @param obj
	 *            输出的map
	 */
	protected void putEmpty(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);
		ResponseUtil.writeJSON(response, obj);
	}

	/**
	 * 输出空结果
	 *
	 * @param obj
	 *            输出的map
	 */
	protected void putOk(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, "ok");
		ResponseUtil.writeJSON(response, obj);
	}

	/**
	 * 输出没有传入参数错误
	 *
	 * @param obj
	 *            输出的map对象
	 */
	protected void putParamEmptyError(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_ERROR_STATUS);
		obj.put(Constant.MSG_MSG, Constant.PARAM_IS_NOT_EMPTY);
		ResponseUtil.writeJSON(response, obj);
	}

	/**
	 * 输出错误
	 *
	 * @param result
	 *            结果
	 * @param msg
	 */
	protected void outError(Map<String, Object> result, String msg) {
		if (result == null) {
			return;
		}
		result.put(Constant.MSG_STATUS, Constant.MSG_ERROR_STATUS);
		result.put(Constant.MSG_MSG, msg);
	}

	/**
	 * 输出成功
	 *
	 * @param result
	 *            结果
	 * @param obj
	 */
	protected void outSuccess(Map<String, Object> result, Object obj) {
		if (result == null) {
			return;
		}
		result.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		result.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);
		result.put(Constant.MSG_RESULT, obj);
//		result.put(Constant.MSG_RESULT, DesCrypt.encode(String.valueOf(obj)));
	}


	/**
	 * 检查结果 如果结果为空抛出异常
	 *
	 * @param registerResult
	 */
	protected void checkResult(Map<String, Object> registerResult) {
		if (CollectionUtils.isEmpty(registerResult)) {
			throw new RuntimeException();
		}
	}
}
