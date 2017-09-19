package com.niuka.common.constant;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ResourceBundle;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

/**
 * Created by lf on 2016/9/12.
 * 公共常量
 */
public class Constant implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static ResourceBundle RESOURC_EBUNDLE;

    static {
        RESOURC_EBUNDLE = ResourceBundle.getBundle("constant");
    }

    // return status
    public static final String MSG_STATUS = RESOURC_EBUNDLE.getString("msg_status");

    // return msg
    public static final String MSG_MSG = RESOURC_EBUNDLE.getString("msg_msg");

    // 返回数据结果
    public static final String MSG_RESULT = RESOURC_EBUNDLE.getString("msg_result");

    // return 成功状态
    public static final String MSG_SUCCESS_CODE = RESOURC_EBUNDLE.getString("msg_success_code");

    // return 成功备注
    public static final String MSG_SUCCESS = RESOURC_EBUNDLE.getString("msg_success");

    // return 参数不能为空
    public static final String PARAM_IS_NOT_EMPTY = RESOURC_EBUNDLE.getString("param_is_not_empty");

    // return 错误状态
    public static final String MSG_ERROR_STATUS = RESOURC_EBUNDLE.getString("msg_error_status");

    // return 数据库异常
    public static final String DATABASE_ERROR = RESOURC_EBUNDLE.getString("database_error");

    // 会员头像默认路径
    public static final String HEAD_IMG_URL = RESOURC_EBUNDLE.getString("head_img_url");


    // 默认分页大小
    public static final String DISKPATH = "";

    //图片大小
//    public static final Integer IMAGE_SIZE = Integer.valueOf(RESOURC_EBUNDLE.getString("image_size"));
    public static final Integer IMAGE_SIZE = 1;



    /**
     * 待付款状态订单
     */
    public static final Integer ORDER_STATUS_1 = 1;

    /**
     * 待发货状态订单
     */
    public static final Integer ORDER_STATUS_2 = 2;
    /**
     * 待收货
     */
    public static final Integer ORDER_STATUS_3 = 3;
    /**
     * 待评价
     */
    public static final Integer ORDER_STATUS_4 = 4;

    /**
     * 退换货
     */
    public static final Integer ORDER_STATUS_5 = 5;
    /**
     * 已评价
     */
    public static final Integer ORDER_STATUS_6 = 6;

    /**
     * 默认字符集
     */
    public static final String CHARSET = "UTF-8";

    /**
     * 默认分割符号
     */
    public static final String SEPARATE = "[,，]";

    public static void main(String[] args) {
        System.out.println(IMAGE_SIZE);
    }

}
