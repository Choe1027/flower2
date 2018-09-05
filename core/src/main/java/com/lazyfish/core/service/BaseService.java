package com.lazyfish.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author cyk
 * @date 2018/9/4/004 15:26
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BaseService<T> {

    /*
        Page 对象说明
         content list数组对象
         first 是否是首页
         last 是否是最后一页
         number 当前页码 从0开始
         numberOfElements 当前页码的数据长度
         size pageSize 页码的数量
         totalElements 总的数据数量
         totalPages 总页数
     */

    /**
     * 分页查询
     *
     * @param t        条件对象
     * @param page     当前请求页 从0开始
     * @param pageSize 一页显示的数量
     * @return
     */
    Page<T> listPage(T t, int page, int pageSize);

    /**
     * 分页降序查询 按照创建时间降序排序
     * @param t        条件对象
     * @param page     当前请求页 从0开始
     * @param pageSize 一页显示的数量
     * @return
     */
    Page<T> listPageCreateTimeDesc(T t, int page, int pageSize);

    /**
     *  根据传入的条件进行排序
     * @param t  条件对象
     * @param page 页码 从0开始
     * @param pageSize 每页显示的数量
     * @param orders 排序方式集合
     * @return
     */
    Page<T> listPageByOrder(T t, int page, int pageSize,Sort.Order... orders);

    /**
     * 根据条件获取所有对象
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 创建时间降序获取所有对象
     * @param t
     * @return
     */
    List<T> selectCreateTimeDesc(T t);

    /**
     * 根据自定义的排列顺序进行排序
     * @param t
     * @param orders
     * @return
     */
    List<T> selectByOrder(T t, Sort.Order... orders);

    /**
     *  根据id获取对象
     * @param id 对象的id
     * @return
     */
    T getById(Long id);

    /**
     * 根据对象传入的条件获取
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 添加对象
     * @param t
     * @return
     */
    T add(T t);

    /**
     *
     * @param t 要更新的对象， 需要包含id
     * @return
     */
    void update(T t);

    /**
     * 根据id删除
     * @param t 删除的对象，需要包含id
     */
    void delete(T t);
}
