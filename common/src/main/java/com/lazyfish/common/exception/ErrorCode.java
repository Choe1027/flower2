package com.lazyfish.common.exception;

/**
 * @author cyk
 * @date 2018/9/3/003 16:10
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public enum ErrorCode {
    not_known_error(-1,"未知错误","未知错误"),
    system_error(-9999,"系统服务异常","系统服务异常"),
    system_lost_param(-9998,"缺少请求参数","缺少请求参数"),
    ;

    private Integer code;
    private String describle;
    private String logs;

    private ErrorCode(Integer code, String describle, String logs) {
        this.code = code;
        this.describle = describle;
        this.logs = logs;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}
