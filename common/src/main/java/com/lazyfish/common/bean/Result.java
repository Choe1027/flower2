package com.lazyfish.common.bean;

/**
 * @author cyk
 * @date 2018/9/7/007 15:19
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class Result {

    /**
     * 状态 1表示成功 0表示失败
     */
    private Integer status;
    /**
     * 状态描述信息
     */
    private String message;
    /**
     * 需要携带的数据
     */
    private Object data;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
