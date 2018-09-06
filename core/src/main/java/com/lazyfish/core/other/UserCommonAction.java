package com.lazyfish.core.other;

/**
 * @author cyk
 * @date 2018/9/6/006 16:15
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface UserCommonAction<T> {

    T findByMobile(String mobile);
}
