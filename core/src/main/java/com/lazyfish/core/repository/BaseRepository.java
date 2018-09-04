package com.lazyfish.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cyk
 * @date 2018/9/4/004 14:05
 * @email choe0227@163.com
 * @desc
 *      T findOne(Long id) 根据id获取对象
 *      T findOne(Example example) 根据条件获取对象
 *      List<T> findALl(Example example) 根据条件查询出所有的对象
 *      Page<T> findALL(Pageable pageable) 分页查询
 *      Page<T> findAll(Example example,Pageable pageable)
 *      Page<T> findAll(Specification<T> var1, Pageable var2);
 *
 * @modifier
 * @modify_time
 * @modify_remark
 */
public interface BaseRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {


}
