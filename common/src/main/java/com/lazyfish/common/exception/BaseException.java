package com.lazyfish.common.exception;

import com.lazyfish.common.utils.StringUtil;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/9/3/003 16:09
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BaseException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6812202525292547656L;

    private Integer code;
    private String logs;
    private String describle;
    private ErrorCode errorCode;

    public  BaseException(String decrible){
        super(decrible);
    }

    private BaseException(Integer code,String logs,String describle){
        super(StringUtil.isEmpty(logs)?(StringUtil.isEmpty(describle)?"未知错误":describle):logs);
    }

    private BaseException(ErrorCode errorCode){
        this(errorCode.getCode(),errorCode.getLogs(),errorCode.getDescrible());
        this.errorCode = errorCode;
    }

    private BaseException(ErrorCode errorCode,String logs){
        this(errorCode.getCode(),StringUtil.isEmpty(logs)?errorCode.getLogs():logs,errorCode.getDescrible());
        this.errorCode = errorCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }
}
