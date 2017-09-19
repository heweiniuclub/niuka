package com.niuka.common.validator.annotation;

import java.lang.annotation.*;

import com.niuka.common.validator.Validator;

/**
 * 自定义请求参数注解
 *
 * @author hewei
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateParam {

    /**
     * 验证器
     * @return
     */
    Validator[] value() default {};

    /**
     * 参数的描述名称
     * @return
     */
    String name()       default "";
}



