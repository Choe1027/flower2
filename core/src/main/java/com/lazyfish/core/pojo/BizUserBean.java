package com.lazyfish.core.pojo;

import javax.persistence.MappedSuperclass;

/**
 * @author cyk
 * @date 2018/9/4/004 15:09
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@MappedSuperclass
public class BizUserBean extends BizBean {
    private static final long serialVersionUID = 1L;
    private String name;
    private String mobile;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
