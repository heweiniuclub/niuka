package com.niuka.api.server.controller.param.input.bindphone;

import com.niuka.api.server.controller.param.input.CommonVO;

/**
 * Created by admin on 2017/9/11.
 */
public class CheckBindPhoneRequest extends CommonVO {

    private CheckBindPhoneVO data;

    public CheckBindPhoneVO getData() {
        return data;
    }

    public void setData(CheckBindPhoneVO data) {
        this.data = data;
    }
}
