package com.lazyfish.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cyk
 * @date 2018/9/4/004 11:37
 * @email choe0227@163.com
 * @desc 登录校验
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginValidate {

    /**
     * 是否需要校验 默认需要校验
     * @return
     */
    boolean required() default true;
}
