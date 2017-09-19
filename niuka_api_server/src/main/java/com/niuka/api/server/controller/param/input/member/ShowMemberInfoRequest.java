package com.niuka.api.server.controller.param.input.member;

import com.niuka.api.server.controller.param.input.CommonVO;

/**
 * Created by admin on 2017/9/11.
 */
public class ShowMemberInfoRequest extends CommonVO {

    private ShowMemberInfoVO data;

    public ShowMemberInfoVO getData() {
        return data;
    }

    public void setData(ShowMemberInfoVO data) {
        this.data = data;
    }
}
