package com.niuka.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 响应工具
 * 
 * @author 何威
 * @since 2016年6月6日
 * @version 0.1 初始版本
 *
 */
public class ResponseUtil {

	/** 默认字符编码 */
	public static final String DEFAULT_CHARACTER_ENCODING = "UTF-8";
	/**
	 * 输出JSON内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 * @param responseMap
	 */
	public static void writeJSON(HttpServletResponse response, Map<String, Object> responseMap) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONString(responseMap));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 输出文本内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 */
	public static void write(HttpServletResponse response, String content) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void write(HttpServletResponse response, Boolean content) {
		write(response, content + "");
	}

	/**
	 * 输出JSON内容 (字符编码为UTF-8)
	 * 
	 * @param response
	 */
	public static void writeJson(HttpServletResponse response, JSONObject jsonObject) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 使用FastJson输出JSON内容 (字符编码为UTF-8)
	 *
	 * @param response
	 * @param responseMap
	 */
	public static void useFastJsonWriteJSON(HttpServletResponse response, Map<String, Object> responseMap) {
		response.setCharacterEncoding(DEFAULT_CHARACTER_ENCODING);
		response.setContentType("application/x-json");
		response.setHeader("Cache-Control", "no-cache");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(JSON.toJSONStringWithDateFormat(responseMap, "yyyy-MM-dd HH:mm:ss"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
