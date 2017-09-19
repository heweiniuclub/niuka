package com.niuka.api.server.controller;

import com.niuka.user.model.User;
import com.niuka.user.rpc.UserService;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by admin on 2017/9/11.
 */
public class ValidateFilter implements Filter {

    private UserService userservice;

    /**
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
        ServletContext sc = request.getServletContext();
        XmlWebApplicationContext cxt = (XmlWebApplicationContext) WebApplicationContextUtils.getWebApplicationContext(sc);

        if(cxt != null && cxt.getBean("userservice") != null && userservice == null){
            userservice = (UserService) cxt.getBean("userservice");
        }
    }

    /**
     */
    @Override
    public void destroy() {

    }
}
