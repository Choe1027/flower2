package com.lazyfish.core.cache;

import com.lazyfish.common.utils.ObjectUtil;
import com.lazyfish.core.pojo.BizBean;
import com.lazyfish.core.service.BaseService;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author cyk
 * @date 2018/9/5/005 16:35
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Component
public class CacheHelper<T extends BizBean> {

    /**
     * 1. 添加操作时，更新缓存。
     * 2. 第一次获取数据，将数据添加到缓存中
     *
     * @param cacheDefinition 缓存的方式接口
     * @param localCache      本地缓存对象
     * @param redisCache      redis缓存服务
     * @param t               已经添加到数据库中的数据
     */
    public void modifyCacheByAddAndGet(CacheDefinition cacheDefinition, Map<Long, T> localCache, CacheService redisCache, T t) {

        if (cacheDefinition.useLocalCache()) {
            localCache.put(t.getId(), t);
        }
        if (cacheDefinition.useRedisCache()) {
            redisCache.setMapValue(t.getClass().getName(), t.getId().toString(), t);
        }
    }

    /**
     * 从缓存中获取数据
     *
     * @param cacheDefinition 缓存方式定义接口
     * @param localCache
     * @param redisCache
     * @param t               传过来的条件对象，本缓存中是根据id缓存
     * @return
     */
    public T getObjFromCache(CacheDefinition cacheDefinition, Map<Long, T> localCache, CacheService redisCache, T t) {
        T cache = null;
        // 先从一级缓存中拿
        if (cacheDefinition.useLocalCache()) {
            cache = localCache.get(t.getId());
            if (cache != null) {
                return cache;
            }
        }
        // 再从二级缓存中拿
        if (cacheDefinition.useRedisCache()) {
            cache = redisCache.getMapValue(t.getClass().getName(), t.getId().toString());
            if (cache != null) {
                return cache;
            }
        }
        return cache;
    }


    /**
     * 更新操作时，更新缓存信息
     *
     * @param cacheDefinition
     * @param baseService
     * @param localCache
     * @param redisCache
     * @param t               要更新的对象(传过来的对象)
     * @return
     */
    public T modifyCacheByUpdate(CacheDefinition cacheDefinition, BaseService<T> baseService, Map<Long, T> localCache, CacheService redisCache, T t) {
        T cache = baseService.getById(t.getId());
        if (cache != null) {
            ObjectUtil.insertObj(cache, t);
        }
        if (cacheDefinition.useLocalCache()) {
            localCache.put(t.getId(), cache);
        }
        if (cacheDefinition.useRedisCache()) {
            redisCache.setMapValue(t.getClass().getName(), t.getId().toString(), cache);
        }
        return cache;
    }

    /**
     * 删除操作时 同时删除缓存
     *
     * @param cacheDefinition
     * @param localCache
     * @param redisCache
     * @param t
     */
    public void modifyCacheByDelete(CacheDefinition cacheDefinition, Map<Long, T> localCache, CacheService redisCache, T t) {

        if (cacheDefinition.useLocalCache()) {
            if (localCache.containsKey(t.getId())) {
                localCache.remove(t.getId());
            }
        }
        if (cacheDefinition.useRedisCache()) {
            if (redisCache.hIsExists(t.getClass().getName(), t.getId().toString())) {
                redisCache.removeMapValue(t.getClass().getName(), t.getId().toString());
            }
        }

    }

}
