package com.lazyfish.service.service;

import com.lazyfish.core.pojo.Role;
import com.lazyfish.core.repository.BaseRepository;
import com.lazyfish.core.service.RoleService;
import com.lazyfish.service.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cyk
 * @date 2018/9/7/007 13:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleRepository repository;
    @Override
    public BaseRepository<Role, Long> getMainRepository() {
        return repository;
    }
}
