package com.lazyfish.service.service;

import com.lazyfish.core.cache.CacheService;
import com.lazyfish.core.pojo.BizUserBean;
import com.lazyfish.core.repository.BaseRepository;
import com.lazyfish.core.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

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
public abstract class BaseServiceImpl<T extends BizUserBean> implements BaseService<T> {

    public abstract BaseRepository<T,Long> getMainRepository();

    @Autowired
    private CacheService cacheService;

    @Override
    public Page<T> listPage(T t,int page, int pageSize) {

        Example<T> example = Example.of(t);
        Pageable pageable = new PageRequest(page,pageSize);
        Page<T> pageData = getMainRepository().findAll(example,pageable);
        return pageData;
    }

    @Override
    public Page<T> listPageCreateTimeDesc(T t, int page, int pageSize) {
        Example<T> example = Example.of(t);
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"create_time");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(page,pageSize,sort);
        Page<T> pageData = getMainRepository().findAll(example,pageable);
        return pageData;
    }

    @Override
    public Page<T> listPageByOrder(T t, int page, int pageSize, Sort.Order... orders) {
        Example<T> example = Example.of(t);
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page,pageSize,sort);
        Page<T> pageData = getMainRepository().findAll(example,pageable);
        return pageData;
    }

    @Override
    public List<T> select(T t) {
        Example<T> example = Example.of(t);
        return getMainRepository().findAll(example);
    }

    @Override
    public List<T> selectCreateTimeDesc(T t) {
        Example<T> example = Example.of(t);
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"create_time"));
        return getMainRepository().findAll(example,sort);
    }

    @Override
    public T getById(Long id) {
        return getMainRepository().findOne(id);
    }

    @Override
    public T get(T t) {
        Example<T> example = Example.of(t);
        return getMainRepository().findOne(example);
    }

    @Override
    @Transactional
    public T add(T t) {
        T save = getMainRepository().save(t);
        getMainRepository().flush();
        return save;
    }

    @Override
    public Integer update(T t) {
        getMainRepository().saveAndFlush(t);
        return null;
    }

    @Override
    public void delete(T t) {
        getMainRepository().delete(t);
    }

    @Override
    public void deleteById(Long id) {
        getMainRepository().delete(id);
    }
}
