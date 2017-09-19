package com.niuka.api.server.controller.param.input.updatebindphone;

import com.niuka.api.server.controller.param.input.CommonVO;

/**
 * Created by admin on 2017/9/11.
 */
public class UpdateBindPhoneRequest extends CommonVO {

    private UpdateBindPhoneVO data;

    public UpdateBindPhoneVO getData() {
        return data;
    }

    public void setData(UpdateBindPhoneVO data) {
        this.data = data;
    }
}
