package com.lazyfish.core.service;

import com.lazyfish.core.pojo.BackUser;

import org.springframework.data.domain.Page;

/**
 * @author cyk
 * @date 2018/9/4/004 15:39
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BackUserService extends BaseService<BackUser> {

    Page<BackUser> search(BackUser backUser);

    BackUser findByMobile(String mobile);

}
