package com.lazyfish.back.ctrl;

import com.lazyfish.common.exception.BaseException;
import com.lazyfish.common.exception.ErrorCode;
import com.lazyfish.core.pojo.BackUser;
import com.lazyfish.core.service.BackUserService;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
@Api("后台用户相关接口")
public class BackUserController {

    @Autowired
    private BackUserService backUserService;

    @ApiOperation(value = "添加后台用户", notes = "添加后台用户")
    @ApiImplicitParam(name = "backUser", value = "后台用户详细信息", required = true, dataType = "BackUser")
    @RequestMapping(method = RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody BackUser backUser){
        backUserService.add(backUser);
        return backUser;
    }

    @ApiOperation(value = "修改后台用户", notes = "修改后台用户信息")
    @ApiParam(name = "id",value = "用户id",required = true)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "backUser", value = "后台用户详细信息", required = true, dataType = "BackUser")
            }
    )
    @RequestMapping(value = "/{id}" , method = RequestMethod.PATCH)
    public Object update(HttpServletRequest request,@PathVariable("id") Long id, @RequestBody BackUser backUser){
        backUser.setId(id);
        BackUser update = backUserService.update(backUser);
        throw new BaseException(ErrorCode.system_lost_param);
//        return update;
    }

    @ApiOperation(value = "测试", notes = "测试")
    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public Object test(HttpServletRequest request){

        return null;
    }
}
