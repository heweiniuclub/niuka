package com.niuka.common.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.ResourceBundle;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpSender {

	public static String batchSend(String mobile, String msg) throws Exception {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod();
		PropertiesUtil p = new PropertiesUtil();//读取配置文件中的参数
		try {
			URI base = new URI(ResourceBundle.getBundle("sendSms").getString("uri"), false);
			method.setURI(new URI(base, "HttpBatchSendSM", false));

            System.out.print(ResourceBundle.getBundle("sendSms").getString("account"));
			method.setQueryString(new NameValuePair[] {
					new NameValuePair("account",ResourceBundle.getBundle("sendSms").getString("account")),
					new NameValuePair("pswd",ResourceBundle.getBundle("sendSms").getString("pswd")),
					new NameValuePair("mobile", mobile),
					new NameValuePair("needstatus", String.valueOf(true)),
					new NameValuePair("msg", "【丰盟汇】"+msg),
					new NameValuePair("product", null),
					new NameValuePair("extno", null) });

			int result = client.executeMethod(method);
			if (result == 200) {
				InputStream in = method.getResponseBodyAsStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				String str = URLDecoder.decode(baos.toString(), "UTF-8");
				return str;
			}
			throw new Exception("HTTP ERROR Status: " + method.getStatusCode()
					+ ":" + method.getStatusText());
		} finally {
			method.releaseConnection();
		}
	}

	public static void main(String[] args) {
		
		try {
		String returnString=batchSend("13556631734", "185978是您的注册验证码，请尽快使用。如非本人操作，请忽略");
			System.out.print(returnString);
		} catch (Exception e) {
			e.printStackTrace();
	}
		
//		List<String> list = new ArrayList<String>();
//		list.add("JavaWeb编程词典"); // 向列表中添加数据
//		list.add("Java编程词典"); // 向列表中添加数据
//		list.add("C#编程词典"); // 向列表中添加数据
//		list.add("ASP.NET编程词典"); // 向列表中添加数据
//		list.add("VC编程词典"); // 向列表中添加数据
//		list.add("SQL编程词典"); // 向列表中添加数据
//		Iterator<String> its = list.iterator(); // 获取集合迭代器
//		System.out.println("集合中所有元素对象：");
//		while (its.hasNext()) { // 循环遍历集合
//			System.out.print(its.next() + "  "); // 输出集合内容
//		}
//		List<String> subList = list.subList(3, 5); // 获取子列表
//		System.out.println("\n截取集合中部分元素：");
//		Iterator it = subList.iterator();
//		while (it.hasNext()) {
//			System.out.print(it.next() + "  ");
//		}
	}

}
