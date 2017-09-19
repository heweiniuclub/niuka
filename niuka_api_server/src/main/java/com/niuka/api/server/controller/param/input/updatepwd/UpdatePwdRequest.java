package com.niuka.api.server.controller.param.input.updatepwd;

import com.niuka.api.server.controller.param.input.CommonVO;

/**
 * Created by admin on 2017/9/11.
 */
public class UpdatePwdRequest extends CommonVO {

    private UpdatePwdVO data;

    public UpdatePwdVO getData() {
        return data;
    }

    public void setData(UpdatePwdVO data) {
        this.data = data;
    }
}
