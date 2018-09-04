package com.lazyfish.service.service;

import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.repository.BaseRepository;
import com.lazyfish.core.service.BackUserService;
import com.lazyfish.service.repository.BackUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyk
 * @date 2018/9/4/004 15:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class BackUserServiceImpl extends BaseServiceImpl<BackUser> implements BackUserService {

    @Autowired
    private BackUserRepository backUserRepository;

    @Override
    public BaseRepository<BackUser> getMainRepository() {
        return backUserRepository;
    }
}
