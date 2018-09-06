package com.lazyfish.core.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cyk
 * @date 2018/9/6/006 16:37
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Entity
@Table(name = "user_role")
public class UserRole extends BizBean {

    private Long role_id;
    private Long user_id;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
