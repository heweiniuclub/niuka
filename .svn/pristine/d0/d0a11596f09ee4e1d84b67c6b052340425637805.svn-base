package com.niuka.api.server.controller.filter;


import com.alibaba.fastjson.JSONObject;
import com.niuka.common.config.ConfigUtils;
import com.niuka.common.util.ResponseUtil;
import com.niuka.customer.model.Customer;
import com.niuka.customer.rpc.api.CustomerApiService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 *  api接口前端后端编解码过滤器
 * Created by admin on 2017/8/24.
 */
public class CustomerValidatorFilter implements Filter {

    private CustomerApiService customerapiservice;
    
    String param = "";

    /**
     * 初始化方法
     *
     * @param filterConfig
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	
    }

    /**
     *
     * @param request
     * @param response
     * @param chain
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			
//			String method = "GET";
//			ServletRequest requestWrapper = null;
//			if (request instanceof HttpServletRequest) {
//				method = ((HttpServletRequest) request).getMethod();
//				requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request); // 替换
//			}
//
//			if ("POST".equalsIgnoreCase(method)) {
//				param = this.getBodyString(requestWrapper.getReader());
//			}
		        
			HttpServletRequest req = (HttpServletRequest) request;
			
			ServletContext sc = req.getServletContext();
	        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);

	        if(cxt != null && cxt.getBean("customerapiservice") != null && customerapiservice == null){
	        	customerapiservice = (CustomerApiService) cxt.getBean("customerapiservice");
	        }
	        
			//获得客户参数
//			String params = DesCrypt.decode(req.getParameter(ConfigUtils.getProperty("api.param.name")));
//			JSONObject jsonObject = JSONObject.parseObject(params);
			JSONObject jsonObject = JSONObject.parseObject(req.getParameter(ConfigUtils.getProperty("api.param.name")));
			Integer customerId = Integer.parseInt(jsonObject.get("customerId").toString());
			if (customerId != null && customerId > 0) {
//				chain.doFilter(req, response);
				//检查客户是否存在
//				int count = customerapiservice.checkCustomerExist(customerId);
				Customer customer = customerapiservice.checkCustomerExist(customerId);
//				Customer customer1 = new Customer();
//	            customer1.setCustomerName("111");
//	            customerapiservice.add(customer1);
				if (customer != null) {
					chain.doFilter(req, response);
				} else {
					ResponseUtil.write((HttpServletResponse)response, "客户不存在");
				}
//				if (count > 0) {
//					chain.doFilter(req, response);
//				} else {
//					ResponseUtil.write((HttpServletResponse)response, "客户不存在");
//				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    //获取request请求body中参数
   	public static String getBodyString(BufferedReader br) {
		String inputLine;
		String str = "";
		try {
			while ((inputLine = br.readLine()) != null) {
				str += inputLine;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return str;
   	}
    
    /**
     *
     * 销毁方法
     */
    @Override
    public void destroy() {

    }

    
}
