package com.niuka.common.util;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.niuka.common.constant.Constant;
import com.niuka.common.util.DesCrypt;

/**
 * 输出工具类
 * @author Administrator
 *
 */
public class OutputUtil {
	
	protected static final Logger LOG = LoggerFactory.getLogger(OutputUtil.class);

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
	protected static void putSuccess(Map<String, Object> obj, Object vo) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);

		// 结果
		obj.put(Constant.MSG_RESULT, DesCrypt.encode(String.valueOf(vo)));
	}

	/**
	 * 输出空结果
	 *
	 * @param obj
	 *            输出的map
	 */
	protected static void putEmpty(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, Constant.MSG_SUCCESS);
	}

	/**
	 * 输出空结果
	 *
	 * @param obj
	 *            输出的map
	 */
	protected static void putOk(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_SUCCESS_CODE);
		obj.put(Constant.MSG_MSG, "ok");
	}

	/**
	 * 输出没有传入参数错误
	 *
	 * @param obj
	 *            输出的map对象
	 */
	protected static void putParamEmptyError(Map<String, Object> obj) {
		obj.put(Constant.MSG_STATUS, Constant.MSG_ERROR_STATUS);
		obj.put(Constant.MSG_MSG, Constant.PARAM_IS_NOT_EMPTY);
	}

	/**
	 * 输出错误
	 *
	 * @param result
	 *            结果
	 * @param msg
	 */
	public static void outError(Map<String, Object> result, String msg) {
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
	public static void outSuccess(Map<String, Object> result, Object obj) {
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
	protected static void checkResult(Map<String, Object> registerResult) {
		if (CollectionUtils.isEmpty(registerResult)) {
			throw new RuntimeException();
		}
	}
	
	 /**
     * 参数为空
     *
     * @param result 结果
     */
    public static void outParamEmptyError(Map<String, Object> result) {
        outError(result, Constant.PARAM_IS_NOT_EMPTY);
    }
	
}
