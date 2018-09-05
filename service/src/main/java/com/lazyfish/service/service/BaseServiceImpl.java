package com.lazyfish.service.service;

import com.lazyfish.common.exception.BaseException;
import com.lazyfish.common.exception.ErrorCode;
import com.lazyfish.common.utils.LoggerUtil;
import com.lazyfish.common.utils.ObjectUtil;
import com.lazyfish.core.cache.CacheDefinition;
import com.lazyfish.core.cache.CacheHelper;
import com.lazyfish.core.cache.CacheService;
import com.lazyfish.core.pojo.BizBean;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

/**
 * @author cyk
 * @date 2018/9/4/004 15:28
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public abstract class BaseServiceImpl<T extends BizBean> implements BaseService<T>, CacheDefinition {

    public abstract BaseRepository<T, Long> getMainRepository();

    /**
     * 本地缓存
     */
    private Map<Long, T> cacheMap = new ConcurrentHashMap<Long, T>();

    @Autowired
    private CacheService cacheService;
    @Autowired
    private CacheHelper<T> cacheHelper;

    @PostConstruct
    protected void initLocalCache(){
        if (useLocalCache() && useLocalCache()) {
            synchronized (this) {
                if(useLocalCache() && useLocalCache()) {
                    cacheMap.clear();
                    Class<Object> generic = ObjectUtil.getGeneric(getClass());
                    T object = (T) ObjectUtil.createObject(generic);
                    Example<T> example = Example.of(object);
                    List<T> select = getMainRepository().findAll(example);
                    for (T t : select) {
                        cacheMap.put(t.getId(), t);
                    }
                    LoggerUtil.info(this.getClass(), generic+"初始化本地缓存!");
                }
            }
        }
    }

    @Override
    public Page<T> listPage(T t, int page, int pageSize) {
        return listPageByOrder(t, page, pageSize, null);
    }

    @Override
    public Page<T> listPageCreateTimeDesc(T t, int page, int pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "create_time");
        return listPageByOrder(t, page, pageSize, order);
    }

    @Override
    public Page<T> listPageByOrder(T t, int page, int pageSize, Sort.Order... orders) {
        Example<T> example = Example.of(t);
        Sort sort = null;
        if (orders != null) {
            sort = new Sort(orders);
        }
        Pageable pageable = new PageRequest(page, pageSize, sort);
        Page<T> pageData = getMainRepository().findAll(example, pageable);
        return pageData;
    }

    @Override
    public List<T> select(T t) {
        return selectByOrder(t, null);
    }

    @Override
    public List<T> selectCreateTimeDesc(T t) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "create_time");
        return selectByOrder(t, order);
    }

    @Override
    public List<T> selectByOrder(T t, Sort.Order... orders) {
        Example<T> example = Example.of(t);
        Sort sort = null;
        if (orders != null) {
            sort = new Sort(orders);
        }
        return getMainRepository().findAll(example, sort);
    }

    @Override
    public T getById(Long id) {
        T t = ObjectUtil.createObject(ObjectUtil.getGeneric(this.getClass()));
        t.setId(id);
        return get(t);
    }

    @Override
    public T get(T t) {
        T result = null;
        if (t.getId() != null && !t.getId().equals(0L)) {
            result = cacheHelper.getObjFromCache(this, cacheMap, cacheService, t);
            if (result != null) {
                return result;
            }
        }
        Example<T> example = Example.of(t);
        result = getMainRepository().findOne(example);
        if (result != null){
            cacheHelper.modifyCacheByAddAndGet(this,cacheMap,cacheService,result);
        }
        return result;
    }

    @Override
    @Transactional
    public T add(T t) {
        T save = getMainRepository().save(t);
        getMainRepository().flush();
        cacheHelper.modifyCacheByAddAndGet(this, cacheMap, cacheService, save);
        return save;
    }

    @Override
    public void update(T t) {
        if (t.getId() == null || t.getId().equals(0L)) {
            throw new BaseException(ErrorCode.system_lost_param);
        }
        getMainRepository().saveAndFlush(t);
        cacheHelper.modifyCacheByUpdate(this, this, cacheMap, cacheService, t);
    }

    @Override
    public void delete(T t) {
        if (t.getId() == null || t.getId().equals(0L)) {
            throw new BaseException(ErrorCode.system_lost_param);
        }
        getMainRepository().delete(t.getId());
        cacheHelper.modifyCacheByDelete(this, cacheMap, cacheService, t);
    }

    @Override
    public boolean useLocalCache() {
        return false;
    }

    @Override
    public boolean useRedisCache() {
        return false;
    }

    @Override
    public boolean isNeedCache2LocalInit() {
        return false;
    }
}
