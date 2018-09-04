package com.lazyfish.service.service;

import com.lazyfish.core.cache.CacheService;
import com.lazyfish.core.pojo.BaseBean;
import com.lazyfish.core.repository.BaseRepository;
import com.lazyfish.core.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author cyk
 * @date 2018/9/4/004 15:28
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public abstract class BaseServiceImpl<T extends BaseBean> implements BaseService<T> {

    public abstract BaseRepository<T> getMainRepository();

    @Autowired
    private CacheService cacheService;

    @Override
    public Page<T> listPage(T t) {

        Example<T> example = Example.of(t);
//        Pageable pageable = new PageRequest()
        return null;
    }

    @Override
    public Page<T> listPage(T t, Long start_time, Long end_time) {
        return null;
    }

    @Override
    public Page<T> listPageDesc(T t) {
        return null;
    }

    @Override
    public Page<T> listPageDesc(T t, Long start_time, Long end_time) {
        return null;
    }

    @Override
    public Integer update(T t) {
        return null;
    }

    @Override
    public Integer add(T t) {
        return null;
    }

    @Override
    public T get(T t) {
        return null;
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public Integer delete(T t) {
        return null;
    }

    @Override
    public List<T> select(T t) {
        return null;
    }

    @Override
    public List<T> selectDesc(T t) {
        return null;
    }

    @Override
    public List<T> select(T t, Long start_time, Long end_time) {
        return null;
    }

    @Override
    public List<T> selectDesc(T t, Long start_time, Long end_time) {
        return null;
    }
}
