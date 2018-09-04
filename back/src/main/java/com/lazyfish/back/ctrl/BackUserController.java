package com.lazyfish.back.ctrl;

import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.service.BackUserService;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyk
 * @date 2018/9/4/004 15:53
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@RestController
@RequestMapping("/user")
public class BackUserController {

    @Autowired
    private BackUserService backUserService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BackUser add(HttpServletRequest request, @RequestBody BackUser backUser){
        backUserService.add(backUser);
        return backUser;
    }

}
