package com.lazyfish.core.repository;

import com.lazyfish.core.pojo.BizUserBean;

/**
 * @author cyk
 * @date 2018/9/4/004 16:51
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BaseUserRepository<T extends BizUserBean> extends BaseRepository {

    T findByMobile(String mobile);
}
