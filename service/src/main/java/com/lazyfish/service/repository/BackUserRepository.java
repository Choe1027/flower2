package com.lazyfish.service.repository;

import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.repository.BaseUserRepository;

import org.springframework.stereotype.Repository;

/**
 * @author cyk
 * @date 2018/9/4/004 15:20
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Repository
public interface BackUserRepository extends BaseUserRepository<BackUser,Long> {

}
