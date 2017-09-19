package com.niuka.common.filter;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.niuka.common.cache.RedisCache;
import com.niuka.common.config.ConfigUtils;
import com.niuka.common.model.ResultCode;
import com.niuka.common.model.Token;
import com.niuka.common.util.DesCrypt;
import com.niuka.common.util.MD5Util;
import com.niuka.common.util.ResponseUtil;
import com.niuka.common.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 *  api接口前端后端编解码过滤器
 * Created by admin on 2017/8/24.
 */
public class ApivalidatorFilter implements Filter {

    @Resource
    private RedisCache<String> redisCache;

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
        HttpServletResponse res = (HttpServletResponse) response;
        try {
            String param = ConfigUtils.getProperty("api.param.name");
            String parameter = request.getParameter(param);
            String decode = DesCrypt.decode(parameter);
            JSONObject jsonObj = (JSONObject) JSON.parse(decode);
            Map<String,Object>  result = new HashMap<String,Object>();

            if(jsonObj!=null){
                Token validateStr = (Token) jsonObj.get("validateStr");
                if(validateStr==null){
                    result.put("status",ResultCode.API_AUTO_ERROR);
                    result.put("msg_msg","api鉴权错误!");
                    ResponseUtil.writeJSON(res, result);
                }

                if(validateStr.getPersonalId() == 0 || StringUtils.isBlank(validateStr.getSign()) ||  StringUtils.isBlank(validateStr.getToken())){
                    result.put("status",ResultCode.API_AUTO_ERROR);
                    result.put("msg_msg","api鉴权错误!");
                    ResponseUtil.writeJSON(res, result);
                }

                // 判断token是否存在

                String personalId = String.valueOf(validateStr.getPersonalId());

                String token = redisCache.get(personalId);
                if(token.equals(validateStr.getToken())){
                    // 不为空就需要校验 校验规则按照字母的降序来进行加密
                    Map<String, Object> map = new HashMap<String,Object>();
                    map.put("personal_id",validateStr.getPersonalId());
                    map.put("token",validateStr.getToken());
                    map.put("timestamp",validateStr.getTimestamp());

                    String sign = createSign(map, false);

                    if(sign.equals(validateStr.getSign())){
                        chain.doFilter(request, response);
                    }else{
                        result.put("status",ResultCode.API_AUTO_ERROR);
                        result.put("msg_msg","api鉴权错误!");
                        ResponseUtil.writeJSON(res, result);
                    }
                }else{
                    result.put("status",ResultCode.API_AUTO_ERROR);
                    result.put("msg_msg","api鉴权错误!");
                    ResponseUtil.writeJSON(res, result);
                }

            }else{
                result.put("status",ResultCode.API_AUTO_ERROR);
                result.put("msg_msg","api鉴权错误!");
                ResponseUtil.writeJSON(res, result);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }



    }


    /**
     *  生成秘要
     * @param params
     * @param encode
     * @return
     * @throws UnsupportedEncodingException
     */


    public static String createSign(Map<String, Object> params, boolean encode)
            throws UnsupportedEncodingException {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuffer temp = new StringBuffer();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            if (encode) {
                temp.append(URLEncoder.encode(valueString, "UTF-8"));
            } else {
                temp.append(valueString);
            }
        }
        return MD5Util.string2MD5(temp.toString()).toUpperCase();
    }

    /**
     *
     * 销毁方法
     */
    @Override
    public void destroy() {

    }
}
