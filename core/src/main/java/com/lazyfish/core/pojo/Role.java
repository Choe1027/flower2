package com.lazyfish.core.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author cyk
 * @date 2018/9/6/006 16:22
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Entity
@Table(name = "role")
public class Role extends BizBean{
    /**角色名称*/
    private String name;
    /**角色功能描述*/
    private String remark;
    /**0 启用 1 禁用*/
    private Integer state;

    @ManyToMany(mappedBy = "roles")
    @JSONField(serialize = false)
    private Set<BackUser> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Set<BackUser> getUsers() {
        return users;
    }

    public void setUsers(Set<BackUser> users) {
        this.users = users;
    }
}
