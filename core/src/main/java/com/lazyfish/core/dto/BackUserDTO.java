package com.lazyfish.core.dto;

import com.lazyfish.core.pojo.BackUser;

/**
 * @author cyk
 * @date 2018/9/4/004 16:37
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BackUserDTO extends BackUser {

    private String user_name;


    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
