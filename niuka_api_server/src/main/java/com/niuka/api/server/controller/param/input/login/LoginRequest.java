package com.niuka.api.server.controller.param.input.login;

import com.niuka.api.server.controller.param.input.CommonVO;

/**
 * Created by admin on 2017/9/11.
 */
public class LoginRequest extends CommonVO {

    private LoginVO data;

    public LoginVO getData() {
        return data;
    }

    public void setData(LoginVO data) {
        this.data = data;
    }
}
