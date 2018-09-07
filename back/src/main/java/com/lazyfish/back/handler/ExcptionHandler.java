package com.lazyfish.back.handler;

import com.lazyfish.common.bean.Result;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cyk
 * @date 2018/9/7/007 15:14
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@ControllerAdvice
public class ExcptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    Result handleBizException(Exception ex){

        Result result = null;
        return result;
    }



}
