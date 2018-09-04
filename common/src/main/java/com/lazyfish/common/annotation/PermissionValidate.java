package com.lazyfish.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cyk
 * @date 2018/9/4/004 11:32
 * @email choe0227@163.com
 * @desc 接口权限校验注解
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionValidate {
    /** 具备该接口的角色*/
    int[] roles();
}
