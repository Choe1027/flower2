package com.lazyfish.core.pojo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author cyk
 * @date 2018/9/4/004 15:15
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Entity
@Table(name = "back_user")
public class BackUser extends BizUserBean {

    private String account;
    private Integer state;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}
