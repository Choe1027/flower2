package com.lazyfish.common.utils;

import com.lazyfish.common.bean.Result;
import com.lazyfish.common.exception.BaseException;

/**
 * @author cyk
 * @date 2018/9/7/007 17:38
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class ResponseUtil {

    public final static Integer successCode = 1;
    public final static String successMsg = "success";
    public final static Integer errorCode = 0;
    public final static String errorMsg = "failed";
    /**
     * 返回成功，传入返回体具体出參
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setStatus(successCode);
        result.setMessage(successMsg);
        result.setData(object);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setStatus(errorCode);
        result.setMessage(errorMsg);
        result.setData(null);
        return result;
    }

    /**
     * 返回异常信息，在已知的范围内
     * @param exceptionEnum
     * @return
     */
    public static Result error(BaseException exceptionEnum){
        Result result = new Result();
        result.setStatus(exceptionEnum.getCode());
        result.setMessage(exceptionEnum.getDescrible());
        result.setData(null);
        return result;
    }

}
