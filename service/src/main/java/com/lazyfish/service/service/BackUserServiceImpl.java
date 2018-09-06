package com.lazyfish.service.service;

import com.lazyfish.common.exception.BaseException;
import com.lazyfish.common.exception.ErrorCode;
import com.lazyfish.common.utils.StringUtil;
import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.repository.BaseRepository;
import com.lazyfish.core.service.BackUserService;
import com.lazyfish.service.repository.BackUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
@Transactional
public class BackUserServiceImpl extends BaseServiceImpl<BackUser> implements BackUserService {

    @Autowired
    private BackUserRepository backUserRepository;

    @Override
    public BaseRepository<BackUser,Long> getMainRepository() {
        return backUserRepository;
    }

    @Override
    public Page<BackUser> search(BackUser backUser) {

        Pageable pageable = new PageRequest(1,1);
        Specification<BackUser> specification = new Specification<BackUser>() {
            @Override
            public Predicate toPredicate(Root<BackUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
//                if (!StringUtil.isEmpty(backUser.getAccount())){
//                    predicates.add(cb.like(root.get("account").as(String.class), "%" + backUser.getAccount() + "%"));
//                }
                Predicate[] pre = new Predicate[predicates.size()];
                criteriaQuery.where(predicates.toArray(pre));
                return cb.and(predicates.toArray(pre));
            }
        };
        return backUserRepository.findAll(specification,pageable);
    }

    @Override
    public BackUser findByMobile(String mobile) {
        if (StringUtil.isEmpty(mobile)){
            throw new BaseException(ErrorCode.system_lost_param,"手机号为空");
        }
        return backUserRepository.findByMobile(mobile);
    }
}
