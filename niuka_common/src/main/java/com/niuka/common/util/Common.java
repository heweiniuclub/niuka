package com.niuka.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.niuka.common.constant.Constant;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

public class Common {
	private static Logger loger = LoggerFactory.getLogger(Common.class);
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");
	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static List<Map<String, String>> list = new ArrayList<Map<String, String>>();

	// 随机生成六位数
	public static int getRandomNum() {
		Random r = new Random();
		return r.nextInt(900000) + 100000;
	}

	// 随机生成8位数
	public static int getRandomNumEight() {
		Random r = new Random();
		return r.nextInt(90000000) + 10000000;
	}

	// Json 数据方法

	public static void JSONChangePhoto(JSONObject json2) {
		if (json2.get("userIdx") == null)
			return;
		if (json2.get("userIdx") == "")
			return;
		if (json2.get("userIdx") == "0")
			return;
		if ((json2.get("photo") != null) && (json2.get("photo") != "")
				&& (json2.get("photo") != "null"))
			json2.put("photo", "user_" + json2.get("userIdx") + ".jpg");
		if ((json2.get("clerkPhoto") != null)
				&& (json2.get("clerkPhoto") != "")
				&& (json2.get("clerkPhoto") != "null"))
			json2.put("clerkPhoto", "user_" + json2.get("userIdx") + ".jpg");
	}

	public static void PutJSON(JSONObject json, Object[] obj, String[] flds) {
		for (int i = 0; i < flds.length; i++) {
			json.put(flds[i], ((obj[i] == null) ? "" : obj[i].toString()));
		}
		JSONChangePhoto(json);
	}

	public static void PutListJSON(JSONObject json, List list, String[] flds) {
		for (int i = 0; i < flds.length; i++) {
			json.put(flds[i], ((list.get(i) == null) ? "" : list.get(i)
					.toString()));
		}
		JSONChangePhoto(json);
	}

	public static void PutListJSON2(JSONObject json, List list, String[] flds) {
		List<JSONObject> jsons = new ArrayList<JSONObject>();
		JSONObject jsonTemp = new JSONObject();
		for (int i = 0; i < flds.length; i++) {
			jsonTemp.put(flds[i], ((list.get(i) == null) ? "" : list.get(i)
					.toString()));
		}
		jsons.add(jsonTemp);
		json.put("result", jsons);
		JSONChangePhoto(json);
	}

	public static void PutJSONArray(JSONObject json, String fld,
			List<Object[]> objList, String[] flds) {
		JSONArray jsonArr = new JSONArray();
		// List<JSONObject> jsons = new ArrayList<JSONObject>();
		for (int i = 0; i < objList.size(); i++) {
			// System.out.println(objList.get(i) + "-------------");
			Object[] obj = (Object[]) objList.get(i);
			JSONObject row = new JSONObject();
			PutJSON(row, obj, flds);
			JSONChangePhoto(row);
			// jsons.add(row);
			jsonArr.add(row);
		}
		// json.put(fld, jsons);
		json.put(fld, jsonArr);
	}

	public static String JSONArray(JSONObject json, String fld,
			List<Object[]> objList, String[] flds) {
		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < objList.size(); i++) {
			Object[] obj = (Object[]) objList.get(i);
			JSONObject row = new JSONObject();
			PutJSON(row, obj, flds);
			JSONChangePhoto(row);
			jsonArr.add(row);
		}

		return jsonArr.toString();
	}

	public static void PutJSONArrayFromBE(JSONObject json, String fld,
			List<Object[]> objList, String[] flds, int begin, int end) {
		JSONArray jsonArr = new JSONArray();
		/*
		 * for(int i=begin; i<end; i++){ if(i >= objList.size()) break; Object[]
		 * obj = (Object[]) objList.get(i); JSONObject row = new JSONObject();
		 * PutJSON(row, obj, flds); JSONChangePhoto(row); jsonArr.add(row); }
		 */
		if (end > objList.size()) {
			end = objList.size();
		}

		for (int i = end - 1; i > begin - 1; i--) {
			if (i < 0)
				break;
			Object[] obj = (Object[]) objList.get(i);
			JSONObject row = new JSONObject();
			PutJSON(row, obj, flds);
			JSONChangePhoto(row);
			jsonArr.add(row);
		}
		json.put(fld, jsonArr);

	}

	public static void PutJSON2(JSONObject json, Object[] obj, String[] flds,
			int[] idxs) {
		for (int i = 0; i < flds.length; i++)
			json.put(flds[i],
					((obj[idxs[i]] == null) ? "" : obj[idxs[i]].toString()));
		JSONChangePhoto(json);
	}

	public static void PutJSONArray2(JSONObject json, String fld,
			List<Object[]> objList, String[] flds, int[] idxs) {
		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < objList.size(); i++) {
			Object[] obj = (Object[]) objList.get(i);
			JSONObject row = new JSONObject();
			PutJSON2(row, obj, flds, idxs);
			JSONChangePhoto(row);
			jsonArr.add(row);
		}
		json.put(fld, jsonArr);
	}

	/**
	 * @param filename
	 */
	// 获取图片后缀名
	public static String getSuffixName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}

		return filename;
	}

	// 生成一个新的图片名称
	public static String getNewImgName(String filename) {
		Date da = new Date();
		String newName = da.getTime() + "." + getSuffixName(filename);
		return newName;
	}

	// 转码
	/*
	 * public static String changeCored(String string) { try { return new
	 * String(string.toString().getBytes("ISO-8859-1"), "UTF-8"); } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); return ""; } }
	 */

	/***
	 * 创建日期：2012-12-27上午09:17:23
	 * <p>
	 * 修改日期：
	 * <p>
	 * 作者：
	 * <p>
	 * TODO
	 * <p>
	 * return 根据大图URL，返回小图URL
	 */
	public static String getMinImgURL(String url) {
		if (url.equals("") || url.equals(null)) {
			return "";
		} else {
			StringBuffer sb = new StringBuffer(url);
			System.out.println(sb.length());
			sb.insert(9, "m");
			return sb.toString();
		}

	}

	/***
	 *
	 * 创建日期：2012-12-28下午03:16:39 修改日期： 作者：xiaoyi TODO
	 *
	 * @param res
	 *            中文字符串：名字
	 * @return 返回名字首字母 return
	 */
	/*
	 * public static String getFirstPinyin(String res) { Pinyin py = new
	 * Pinyin(); String result = py.getFirstAlpha(res);
	 * 
	 * return result; }
	 */

	/***
	 * 创建日期：2012-12-27上午10:52:21
	 * <p>
	 * 修改日期：
	 * <p>
	 * 作者：xiaoyi
	 * <p>
	 * TODO
	 * <p>
	 * return 返回当前系统时间
	 */
	public static String getSystemLoginTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");// 可以方便地修改日期格式
		String hehe = dateFormat.format(now);
		return hehe;

	}

	/***
	 * 创建日期：2012-12-27上午10:52:21
	 * <p>
	 * 修改日期：
	 * <p>
	 * 作者：xiaoyi
	 * <p>
	 * TODO
	 * <p>
	 * return 返回当前系统时间
	 */
	public static String getFormortTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");// 可以方便地修改日期格式
		String hehe = dateFormat.format(now);
		return hehe;
	}

	/***
	 * 创建日期：2012-12-28下午12:01:19 修改日期： 2016-9-13 14:10:12 lf
	 *
	 * @return 返回激活时间 return
	 */
	public static String getNowDate() {
		return DATE_FORMAT.format(new Date());
	}

	/***
	 * add by lf 2016-9-7 14:51:15
	 *
	 * @return 返回时间 return
	 */
	public static String getDateStr() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");// 可以方便地修改日期格式
		return dateFormat.format(new Date());
	}

	/**
	 * Date类型转成Strin类型
	 *
	 * @param cTime
	 * @return
	 */
	public static String convertToString(Date cTime) {
		return DATE_FORMAT.format(cTime);
	}

	/**
	 * Date类型转成String类型 lf 2016-9-14 14:11:49
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTimeFormat(Date date) {
		return DATE_TIME_FORMAT.format(date);
	}

	/***
	 * 创建日期：2012-12-28下午12:05:50 修改日期： 作者：xiaoyi TODO
	 *
	 * @param startTime
	 *            激活时间
	 * @param time
	 *            期限
	 * @return 过期时间 return
	 */
	public static String getEndTime(String startTime, int time) {
		String[] strs = startTime.split("-");
		int year = Integer.parseInt(strs[0]);
		int month = Integer.parseInt(strs[1]);
		int mh = (month + time) % 12;
		year = year + (month + time - mh) / 12;
		mh = mh + 1;
		String endTime = year + "-" + mh + "-" + "1";
		return endTime;
	}

	/**
	 * MD5
	 *
	 * @param source
	 * @return
	 */
	public static String getMD5(byte[] source) {
		String s = null;
		char hexDigits[] = { // 用来将字节转换成 16 进制表示的字符
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
				'e', 'f' };
		try {
			java.security.MessageDigest md = java.security.MessageDigest
					.getInstance("MD5");
			md.update(source);
			byte tmp[] = md.digest(); // MD5 的计算结果是一个 128 位的长整数，
			// 用字节表示就是 16 个字节
			char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符，
			// 所以表示成 16 进制需要 32 个字符
			int k = 0; // 表示转换结果中对应的字符位置
			for (int i = 0; i < 16; i++) { // 从第一个字节开始，对 MD5 的每一个字节
				// 转换成 16 进制字符的转换
				byte byte0 = tmp[i]; // 取第 i 个字节
				str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
				// >>> 为逻辑右移，将符号位一起右移
				str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
			}
			s = new String(str); // 换后的结果转换为字符串

		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	/***
	 * 创建日期：2013-1-8下午03:24:12 修改日期： 作者：xiaoyi TODO
	 *
	 * @param str
	 * @return 将大写字母转化成小写 return
	 */
	public static String getLitter(String str) {
		if (str.equals("*")) {
			return "a";
		} else {
			return str.toLowerCase();
		}
	}

	/**
	 * MD5加密
	 *
	 * @param sourceStr
	 * @return
	 */
	public static String MD5(String sourceStr) {
		if (sourceStr == null || sourceStr.length() == 0)
			return null;
		return Common.getMD5(sourceStr.getBytes());
	}

	public static String[] splitString(String str) {
		Pattern p = Pattern.compile("[.,\"\\?!']");// 增加对应的标点

		Matcher m = p.matcher(str);

		String first = m.replaceAll(""); // 把英文标点符号替换成空，即去掉英文标点符号

		System.out.println("去掉英文标点符号后的字符串：" + first);

		p = Pattern.compile(" {2,}");// 去除多余空格

		m = p.matcher(first);

		String second = m.replaceAll(" ");
		String[] arrs = second.split(" ");
		return arrs;
	}

	public static String sysTimeMs() {
		Date date = new Date();
		String timeMs = "" + date.getTime();
		return timeMs;
	}

	public static String changeTimeFormat(String timeStr) {
		String[] timeStrs = timeStr.split(":");
		int hours = Integer.parseInt(timeStrs[0]);
		int minitus = Integer.parseInt(timeStrs[1]);
		String minitusStr = "" + minitus;
		if (minitus < 10) {
			minitusStr = "0" + minitusStr;
		}
		if (hours < 12) {
			if (hours < 10) {
				return "AM 0" + hours + ":" + minitusStr;
			} else {
				return "AM " + hours + ":" + minitusStr;
			}
		} else {
			int afterChangeTime = hours - 12;
			if (afterChangeTime < 10) {
				return "PM 0" + afterChangeTime + ":" + minitusStr;
			} else {
				return "PM " + afterChangeTime + ":" + minitusStr;
			}
		}
	}

	public static String formatSystemTime(String sysTime) {
		String[] timeStrs = Common.splitString(sysTime);
		String formatTime = timeStrs[0] + " " + changeTimeFormat(timeStrs[1]);
		return formatTime;
	}

	/**
	 * 创建日期：2013-1-24下午2:57:40 修改日期： TODO
	 *
	 * @param content
	 * @return return
	 */

	private static String changeToBreviaryContent(String content) {
		int length = content.length();
		if (length > 16) {
			String afterChange = content.substring(0, 16) + "...";
			return afterChange;
		} else {
			return content;
		}
	}

	// 根据网络路径删除图片压缩文件
	public static int delImage(String realPath) {
		System.out.println("urlImgTemp:" + realPath);
		int res = 0;
		// realPath = realPath.replace("\\JapanShops\\JapanShops\\",
		// "\\JapanShops\\");
		deleteFile(realPath);
		res = 1;
		return res;
	}

	/**
	 * 删除单个文件
	 *
	 * @param fileName
	 *            被删除文件的文件名
	 * @return 单个文件删除成功返回true, 否则返回false
	 */
	public static boolean deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile() && file.exists()) {
			file.delete();
			System.out.println("删除单个文件" + fileName + "成功！");
			return true;
		} else {
			System.out.println("删除单个文件" + fileName + "失败！");
			return false;
		}
	}

	// 将 String 类型转换成 Timestamp
	public static Timestamp getTimestamp(String date) {
		DATE_FORMAT.setLenient(false);
		Timestamp ts = null;
		try {
			ts = new Timestamp(DATE_FORMAT.parse(date).getTime());
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		return ts;
	}

	// 将 Date 类型转换成 Timestamp
	public static Timestamp getTimestamp(Date date) {
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	/*
	 * public static Map<String, String> parseXml(HttpServletRequest request)
	 * throws Exception { // 解析结果存储在HashMap Map<String, String> map = new
	 * HashMap<String, String>(); InputStream inputStream =
	 * request.getInputStream();
	 * 
	 * BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,
	 * "UTF-8")); String temp = ""; StringBuffer sbBuffer = new StringBuffer();
	 * while ((temp = br.readLine()) != null) { sbBuffer.append(temp); }
	 * System.out.println("<------------------------------------>");
	 * loger.debug("<------------------------------------>");
	 * 
	 * System.out.println(sbBuffer.toString());
	 * loger.debug(sbBuffer.toString());
	 * 
	 * System.out.println("<------------------------------------>");
	 * loger.debug("<------------------------------------>");
	 * 
	 * // String dd =
	 * "<xml><appid><![CDATA[wxfde93b79c1509027]]></appid><bank_type><![CDATA[ICBC_CREDIT]]></bank_type><fee_type><![CDATA[CNY]]></fee_type><is_subscribe><![CDATA[Y]]></is_subscribe><mch_id><![CDATA[10022718]]></mch_id><nonce_str><![CDATA[0654007292]]></nonce_str><openid><![CDATA[oecZIt-p1fqzZtyp1H3b_c-NkbTQ]]></openid><out_trade_no><![CDATA[2067]]></out_trade_no><result_code><![CDATA[SUCCESS]]></result_code><return_code><![CDATA[SUCCESS]]></return_code><sign><![CDATA[FDF5859B6723AAD8A0B185FD9BA6772D]]></sign><sub_mch_id><![CDATA[10022718]]></sub_mch_id><time_end><![CDATA[20141113145342]]></time_end><total_fee>1</total_fee><trade_type><![CDATA[JSAPI]]></trade_type><transaction_id><![CDATA[1004400830201411130005873591]]></transaction_id></xml>"
	 * ;
	 * 
	 * // 读取输入流 SAXReader reader = new SAXReader(); Document document =
	 * reader.read(new StringBufferInputStream(sbBuffer.toString())); //
	 * 得到xml根元素 Element root = document.getRootElement(); // 得到根元素的所有子节点
	 * List<Element> elementList = root.elements();
	 * 
	 * // 遍历所有子节点 for (Element e : elementList) map.put(e.getName(),
	 * e.getText());
	 * 
	 * // 释放资源 inputStream.close(); inputStream = null; System.out.print(map);
	 * loger.debug(map);
	 * 
	 * System.out.println("<------------*********************-------------->");
	 * loger.debug("<------------*********************-------------->"); return
	 * map; }
	 */

	/**
	 * 取得当月天数
	 */
	public static int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的天数
	 */
	public static int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	// 保持最后两位小数点.四舍五入
	public static double bigDecimal(Double f, Integer num) {
		BigDecimal bg = new BigDecimal(f);
		double f1 = bg.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
		return f1;
	}

	/**
	 * 计算两个日期之间相差的天数
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @Title: createOrderNum
	 * @Description: 创建订单编号
	 * @return: String
	 */
	public static String createOrderNum() {
		return getFormortTime() + getRandomNumEight();
	}

	/**
	 * 比较两个时间字符串大小
	 * 
	 * @param DATE1
	 * @param DATE2
	 * @return
	 */
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		try {
			// Date dt1 = df.parse(DATE1);
			// Date dt2 = df.parse(DATE2);
			Date dt1 = DATE_FORMAT.parse(DATE1);
			Date dt2 = DATE_FORMAT.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				System.out.println("dt1 在dt2前");
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				System.out.println("dt1在dt2后");
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 将对象转换为boolean
	 *
	 * @param obj
	 * @return
	 */
	public static boolean objectToBoolean(Object obj) {
		if (obj == null) {
			return false;
		}
		String str = obj.toString();
		if (StringUtils.isBlank(str)) {
			return false;
		}
		if ("0".equals(StringUtils.trim(str))) {
			return false;
		}
		if (obj instanceof Boolean) {
			return (Boolean) obj;
		}
		if (obj instanceof Number) {
			Number number = (Number) obj;
			if (number.doubleValue() <= 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否大于0
	 *
	 * @param num
	 * @return
	 */
	public static final boolean zeroPlus(Integer num) {
		if (num != null && num > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否大于0
	 *
	 * @param num
	 * @return
	 */
	public static final boolean zeroPlus(Long num) {
		if (num != null && num > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否大于0
	 *
	 * @param num
	 * @return
	 */
	public static final boolean zeroPlus(Number num) {
		if (num != null && num.doubleValue() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断对象是否为空
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null) {
			return true;
		}
		if (StringUtils.isBlank(obj.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * 获取当前月第一天 2016-9-13 11:49:05 lf
	 * 
	 * @return
	 */
	public static String getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		// 设置为1号,当前日期既为本月第一天
		c.set(Calendar.DAY_OF_MONTH, 1);
		String first = DATE_FORMAT.format(c.getTime());
		System.out.println("===============first:" + first);
		return first;
	}

	/**
	 * 获取当前月最后一天 2016-9-13 11:48:58 lf
	 * 
	 * @return
	 */
	public static String getMonthLastDay() {
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = DATE_FORMAT.format(ca.getTime());
		System.out.println("===============last:" + last);
		return last;
	}

	/**
	 * 生产指定长度的随机字符串 2016-9-24 15:26:05 lf
	 * 
	 * @param len
	 *            随机字符串的长度
	 * @return
	 */
	public static String createRandomStr(int len) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	public static Date convertStringToDate(String date) {
		Date d = null;
		try {
			d = DATE_FORMAT.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static Date getNextDayDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	public static Date getNextDayDate(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, n);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	public static int querydaysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	public static Date getChangeDateByDay(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, n);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	public static Date getChangeDateByMonth(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, n);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	public static Date getChangeDateByYear(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, n);
		Date date1 = new Date(calendar.getTimeInMillis());
		return date1;
	}

	public static void copyFile(String src, String dest) {
		try {
			InputStream inputStream = new FileInputStream(src);
			OutputStream outputStream = new FileOutputStream(dest);

			File file = new File(dest);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			int ch;
			try {
				while ((ch = inputStream.read()) != -1) {
					outputStream.write(ch);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得IOS分享的图片
	 * @param pro_image
	 * @return
	 */
	public static String getIOSShareImage(String srcImage, String destImage) {
		String filePath = Constant.DISKPATH + srcImage;
		File file = new File(filePath);
		String fileName = file.getName();
		
		//输出图片路径
		String outProImage = destImage + fileName;
		try {
			ImageUtil.compressImage(filePath, Constant.DISKPATH + outProImage, Constant.IMAGE_SIZE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outProImage;
	}

}
