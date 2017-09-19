package com.niuka.common.model;

/**
 * api安全对象
 * Created by admin on 2017/8/28.
 */
public class Token  {
    private String token;// token
    private int personalId;// 用户标示id
    private long  timestamp;//时间戳
    private String sign;// md5加密秘要

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
