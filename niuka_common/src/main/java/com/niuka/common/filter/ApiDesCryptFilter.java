package com.niuka.common.filter;


import com.niuka.common.config.ConfigUtils;
import com.niuka.common.util.DesCrypt;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 *  api接口前端后端编解码过滤器
 * Created by admin on 2017/8/24.
 */
public class ApiDesCryptFilter implements Filter {



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
        /**
         *
         * 将前台的paramStr进行解密方便接口使用 然后将解密后的参数覆盖到请求中
         */
//        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper((HttpServletRequest)request);
        chain.doFilter(request, response);
    }


    /**
     *
     * 销毁方法
     */
    @Override
    public void destroy() {
    	
    }
}
