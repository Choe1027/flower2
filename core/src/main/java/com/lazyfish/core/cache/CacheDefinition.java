package com.lazyfish.core.cache;

/**
 * @author cyk
 * @date 2018/9/5/005 16:12
 * @email choe0227@163.com
 * @desc 用来定义缓存的方式
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface CacheDefinition {

    /**
     * 是否使用本地缓存
     * @return
     */
    boolean useLocalCache();

    /**
     * 是否使用Redis缓存
     * @return
     */
    boolean useRedisCache();

    /**
     * 是否需要在启动的时候，就缓存到本地
     * @return
     */
    boolean isNeedCache2LocalInit();
}
